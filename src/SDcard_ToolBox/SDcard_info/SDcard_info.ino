/*
SDCard_info
 This sketch is for testing good wiring and good health of your microSdcard.
 This works only with DroflyProV3 from Drotek www.drotek.com
 
 SDC_info
 Ce programme permet de tester le bon fonctionnement de vôtre carte microSD.
 Ce code ne fonctionne qu'avec la carte DroFlyProV3 de Drotek www.drotek.com
 Decommentez la ligne //#define FRENCH pour traduire les information en français.
 
 wareck : wareck@gmail.com
 
 */

#define FRENCH
#include <SdFat.h>
#define DDR_XCK2    DDRH 
#define PORT_XCK2   PORTH  
#define XCK2        PH2  
const uint8_t spiSpeed = SPI_HALF_SPEED;
Sd2Card card;
SdVolume volume;
SdFile root;
ArduinoOutStream cout(Serial);

char cinBuf[40];
ArduinoInStream cin(Serial, cinBuf, sizeof(cinBuf));

// SD card chip select
int chipSelect=PH2;

void cardOrSpeed() {
  cout << pstr(
  "Try another SD card or reduce the SPI bus speed.\n"
    "The current SPI speed is: ");
  uint8_t divisor = 1;
  for (uint8_t i = 0; i < spiSpeed; i++) divisor *= 2;
  cout << F_CPU * 0.5e-6 / divisor << pstr(" MHz\n");
  cout << pstr("Edit spiSpeed in this sketch to change it.\n");
}

void reformatMsg() {
#ifdef FRENCH
  cout << pstr("Essayez de reformater la carte.  pour de meilleurs resultats\n");
  cout << pstr("utilisez le sketch arduino SdFormatter ou telechargez\n");
  cout << pstr("SDFormatter sur www.sdcard.org/consumer.\n");
#else
  cout << pstr("Try reformatting the card.  For best results use\n");
  cout << pstr("the SdFormatter sketch in SdFat/examples or download\n");
  cout << pstr("and use SDFormatter from www.sdcard.org/consumer.\n");
#endif
}

void setup() {
  Serial.begin(9600);
  DDRH |= (1 << 2);
  while (!Serial) {
  }  // wait for Leonardo
  cout << pstr(
  "\nSDCard info V1.1\n");
  cout << pstr("SdFat library version: ") << SD_FAT_VERSION << endl;
}

bool firstTry = true;



void loop() {

  // read any existing Serial data
  while (Serial.read() >= 0) {
  }
  if (!firstTry) cout << pstr("\nRestarting\n");
  firstTry = false;
#ifdef FRENCH
  cout << pstr("\nAppuyez sur une touche :\n ");
#else
  cout << pstr("\nPress a key :\n ");
#endif 
  cin.readline();


  if (!card.init(spiSpeed, chipSelect)) {
#ifdef FRENCH
    cout << pstr(
    "\nEchec d'initialisation de la carte.\n"
      "Ne pas reformater la carte!\n"
      "Est ce que la carte est correctement installee ?\n"
      "Utilisez vous ce programme sur la carte DroflyProV3?\n");
#else
    cout << pstr(
    "\nSD initialization failed.\n"
      "Do not reformat the card!\n"
      "Is the card correctly inserted?\n"
      "Is chipSelect set to the correct value?\n"
      "Is there a wiring/soldering problem?\n");
#endif  
    cout << pstr("errorCode: ") << hex << showbase << int(card.errorCode());
    cout << pstr(", errorData: ") << int(card.errorData());
    cout << dec << noshowbase << endl;
    return;
  }
#ifdef FRENCH
  cout << pstr("\nInitialisation de la carte reussie.\n");
#else
  cout << pstr("\nCard successfully initialized.\n");
#endif
  cout << endl;

  uint32_t size = card.cardSize();
  if (size == 0) {
#ifdef FRENCH
    cout << pstr("Erreur: ne peut pas determiner la taille de la carte.\n");
#else
    cout << pstr("Can't determine the card size.\n");
#endif
    cardOrSpeed();
    return;
  }
  uint32_t sizeMB = 0.000512 * size + 0.5;
#ifdef FRENCH
  cout << pstr("Taille de la carte: ") << sizeMB;
#else
  cout << pstr("Card size: ") << sizeMB;
#endif
  cout << pstr(" MB (MB = 1,000,000 bytes)\n");
  cout << endl;

  if (!volume.init(&card)) {
    if (card.errorCode()) {
#ifdef FRENCH
      cout << pstr("Impossible de lire la carte...\n");
#else
      cout << pstr("Can't read the card.\n");
#endif
      cardOrSpeed();
    } 
    else {
#ifdef FRENCH
      cout << pstr("Ne peut pas trouver de partitions FAT16/FAT32 valides.\n");
#else
      cout << pstr("Can't find a valid FAT16/FAT32 partition.\n");
#endif

      reformatMsg();
    }
    return;
  }
#ifdef FRENCH
  cout << pstr("Le formatage est en FAT") << int(volume.fatType());
  cout << pstr(", la taille du cluster est de ") << 512L * volume.blocksPerCluster(); 
  cout << pstr(" bytes");
#else
  cout << pstr("Volume is FAT") << int(volume.fatType());
  cout << pstr(", Cluster size (bytes): ") << 512L * volume.blocksPerCluster();
#endif
  cout << endl << endl;

  root.close();
  if (!root.openRoot(&volume)) {
#ifdef FRENCH
    cout << pstr("Ouverture du dossier racine impossible.\n");
#else
    cout << pstr("Can't open root directory.\n");
#endif
    reformatMsg();
    return;
  }
#ifdef FRENCH
  cout << pstr("fichiers presents: (nom date heure taille):\n");
#else
  cout << pstr("Files found (name date time size):\n");
#endif
  root.ls(LS_R | LS_DATE | LS_SIZE);

  if ((sizeMB > 1100 && volume.blocksPerCluster() < 64)
    || (sizeMB < 2200 && volume.fatType() == 32)) {
#ifdef FRENCH
    cout << pstr("\nCette carte devrais etre reformater pour de meilleures performances.\n");
    cout << pstr("Utilisez un cluster de 32Ko pour des cartes superieures a 1 GB.\n");
    cout << pstr("Seules les cartes plus grande que 2 GB doivent etre formatees en FAT32.\n");
#else
    cout << pstr("\nThis card should be reformatted for best performance.\n");
    cout << pstr("Use a cluster size of 32 KB for cards larger than 1 GB.\n");
    cout << pstr("Only cards larger than 2 GB should be formatted FAT32.\n");
#endif
    reformatMsg();
    return;
  }

  // read any existing Serial data
  while (Serial.read() >= 0) {
  }
#ifdef FRENCH
  cout << pstr("\nFin du processus! \nAppuyez sur une touche pour recommencer.\n");
#else
  cout << pstr("\nSuccess!\nType any character to restart.\n");
#endif
  while (Serial.read() < 0) {
  }
}


