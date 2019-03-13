[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; \
    GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked


[Setup]
AppName=Isotope StockManager Helium-Deuterium
AppVersion=1.2.0
DefaultDirName={sd}\Isotope StockManager
DefaultGroupName=Isotope StockManager

[Files]
Source: "commons-lang3-3.8.1.jar"; DestDir : "{app}";
Source: "controlsfx-9.0.0.jar"; DestDir : "{app}";
Source: "gson-2.8.5.jar"; DestDir : "{app}";
Source: "Isotope.jar"; DestDir : "{app}";
Source: "isotope.properties"; DestDir : "{app}";
Source: "postgresql-42.2.1.jar"; DestDir : "{app}";
Source: "README.md"; DestDir : "{app}";
Source: "Ico.png"; DestDir : "{app}"; 

[Icons]
Name: "{userdesktop}\Isotope StockManager"; Filename: "{app}\Isotope.jar"; \
    IconFilename: "Ico.png"; Tasks: desktopicon