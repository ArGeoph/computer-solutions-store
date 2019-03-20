/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  arnasay
 * Created: 28-Dec-2018
 */
--        Create Computers and components tables

	CREATE table pictures (
         pictureID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS 	IDENTITY (START WITH 1, INCREMENT BY 1),
         url VARCHAR(555) NOT NULL UNIQUE,
         description VARCHAR(555) NOT NULL);

	INSERT INTO pictures (url, description) 
	VALUES ('resources/pictures/IMG_0384.JPG', 'The Forbidden City, Beijing, China'),
	('resources/pictures/IMG_0547.JPG', 'The National Gallery, Berlin, Germany'),
	('resources/pictures/IMG_4246.JPG', 'The Gūr-i Amīr, Samarkand, Uzbekistan'),
	('resources/pictures/IMG_2534.JPG', 'Saint Basils Cathedral, Moscow, Russia'),
	('resources/pictures/IMG_2907.JPG', 'The Church of the Holy Sepulchre, Jerusalem, Israel'),
	('resources/pictures/IMG_5724.JPG', 'The Burj Khalifa, Dubai, UAE');


	CREATE table cpu (
            cpuID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
            name VARCHAR(555) NOT NULL,
            description VARCHAR(555) NOT NULL,
            price INT NOT NULL,
            quantity INT NOT NULL);

	CREATE table ram (
            ramID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
            name VARCHAR(555) NOT NULL,
            description VARCHAR(555) NOT NULL,
            price INT NOT NULL,
            quantity INT NOT NULL);

	CREATE table hdd (
            hddID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
            name VARCHAR(555) NOT NULL,
            description VARCHAR(555) NOT NULL,
            price INT NOT NULL,
            quantity INT NOT NULL);
	CREATE table audioCard (
            audioCardID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
            name VARCHAR(555) NOT NULL,
            description VARCHAR(555) NOT NULL,
            price INT NOT NULL,
            quantity INT NOT NULL);
	CREATE table videoCard (
            videoCardID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
            name VARCHAR(555) NOT NULL,
            description VARCHAR(555) NOT NULL,
            price INT NOT NULL,
            quantity INT NOT NULL);
	CREATE table display (
            displayID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
            name VARCHAR(555) NOT NULL,
            description VARCHAR(555) NOT NULL,
            price INT NOT NULL,
            quantity INT NOT NULL);
	CREATE table os (
            osID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
            name VARCHAR(555) NOT NULL,
            description VARCHAR(555) NOT NULL,
            price INT NOT NULL,
            quantity INT NOT NULL);

	CREATE table Computers (
            computerID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
            name VARCHAR(555) NOT NULL,
            pictureURL VARCHAR(555) NOT NULL,
            description VARCHAR(555) NOT NULL,
            price INT NOT NULL,
            quantity INT NOT NULL,
            cpuID INT NOT NULL,
            ramID INT NOT NULL,
            hddID INT NOT NULL,
            videoCardID INT NOT NULL,
            audioCardID INT NOT NULL,
            displayID INT NOT NULL,
            osID INT NOT NULL,
            isCustomizable BOOLEAN NOT NULL,
            isCustomized BOOLEAN NOT NULL,
            compatibleComponents VARCHAR(555),
            URL VARCHAR(555),
            foreign key(cpuID) references cpu(cpuID),
            foreign key(ramID) references ram(ramID),
            foreign key(hddID) references hdd(hddID),
            foreign key(audioCardID) references audioCard(audioCardID),
            foreign key(videoCardID) references videoCard(videoCardID),
            foreign key(displayID) references display(displayID),
            foreign key(osID) references os(osID));

-- INSERT VALUE INTO Tables
INSERT INTO cpu (name, description, price, quantity)
VALUES ('Intel Core i3-6300', 'Intel Boxed Core i3-6300 Dual Core Processor 
        3.8GHz LGA1151. Supports Intel Hyper-Threading Technology^Intel Secure 
Key 14nm Skylake 51W 3MB L3 Cache 2 x 256KB L2 Cache Intel HD Graphics 530', 
110, 9),
('Intel Core i3-8100', 'Processor Base Frequency 3.6 GHz Intel UHD Graphics 
630 DDR4 Support Socket LGA 1151 (300 Series) Fan and Cooler Included ', 
150, 24),
('Intel Core i5-8400', 'Max Turbo Frequency 4.0 GHz Intel UHD Graphics 630 DDR4 
Support Socket LGA 1151 (300 Series) Fan and Cooler Included  ', 
200, 36),
('Intel Core i7-8700K', 'Max Turbo Frequency 4.7 GHz Intel UHD Graphics 630 Unlocked 
Processor DDR4 Support Socket LGA 1151 (300 Series) Cooling device not included - Processor Only ', 
380, 6);

INSERT INTO ram (name, description, price, quantity)
VALUES ('4 GB DDR4 SDRAM DDR4 2400', 'DDR4 2400 (PC4 19200) Timing 16-16-16-39 CAS Latency 16 Voltage 1.2V', 
40, 45),
('8 GB DDR4 SDRAM DDR4 2400', 'DDR4 2400 (PC4 19200) Timing 16-16-16-39 CAS Latency 16 Voltage 1.2V', 
60, 55),
('16 GB DDR4 SDRAM DDR4 2400', ' DDR4 2400 (PC4 19200) Timing 16-16-16-39 CAS Latency 16 Voltage 1.2V', 
120, 46);

INSERT INTO hdd (name, description, price, quantity)
VALUES ('HDD 500GB', '7200 RPM SATA 6Gb/s interface optimizes burst performance; 32MB Cache', 
55, 23),
('HDD 1TB', '7200 RPM SATA 6Gb/s interface optimizes burst performance; 32MB Cache', 
80, 63),
('HDD 2TB', '7200 RPM SATA 6Gb/s interface optimizes burst performance; 32MB Cache ', 
120, 29),
('SDD 256GB', '256GB SATA III V-NAND 2-bit MLC Internal Solid State Drive (SSD)', 
150, 8),
('SDD 512GB', '512GB SATA III V-NAND 2-bit MLC Internal Solid State Drive (SSD)', 
270, 4),
('SDD 1TB', '1TB SATA III V-NAND 2-bit MLC Internal Solid State Drive (SSD)', 
450, 2);

INSERT INTO videoCard (name, description, price, quantity)
VALUES ('No card', 'None', 
0, 9999),
('NVIDIA 210 1GB', '1GB 64-Bit DDR3 Core Clock 520 MHz 1 x DL-DVI-I 1 x HDMI 16 CUDA Cores PCI Express 2.0', 
70, 11),
('GeForce GTX 1050 Ti', '4GB 128-Bit GDDR5 Core Clock 1379 MHz (OC) 1354 MHz (Gaming) 1290 MHz (Silent) Boost Clock 1493 MHz (OC) 1468 MHz (Gaming)
1392 MHz (Silent) 1 x DL-DVI-D 1 x HDMI 2.0 1 x DisplayPort 1.4 768 CUDA Cores PCI Express 3.0 x16 ', 
210, 17),
('GeForce GTX 1060 DirectX 12', '6GB 192-Bit GDDR5 Core Clock 1594 MHz (OC Mode) 1569 MHz (Gaming Mode) 1506 MHz (Silent Mode) Boost Clock 
1809 MHz (OC Mode) 1784 MHz (Gaming Mode) 1708 MHz (Silent Mode) 1 x DL-DVI-D 1 x HDMI 2.0 3 x DisplayPort 1.4 1280 CUDA Cores PCI Express 3.0 x16 ', 
350, 2);

INSERT INTO audioCard (name, description, price, quantity)
VALUES ('No card', 'None', 
0, 9999),
('Creative Sound Blaster Audigy FX PCIe 5.1', 'Easily converts the PC into a cinematic entertainment 
system by providing a compelling 5.1 surround sound Advanced Audio Processing with SBX Pro Studio, a suite of Sound Blaster audio processing tec', 
50, 21),
('Creative Sound Blaster Zx PCIe Gaming Sound Card', '16dB PCIe Gaming Sound Card with 600 ohm Headphone 
Amp and Desktop Audio Control Module.1 x PCI Express, 5.1 Channels TOSLink Optical Input and Output Sound Core 3D Processor Beamforming Microphone', 
140, 14);


INSERT INTO display (name, description, price, quantity)
VALUES ('24-Inch display', '24" Full HD (1920 x 1080) IPS display Dual
 HDMI and VGA ports Stereo 2W speakers 0.27" ultra slim body with frameless design', 
160, 8),
('27-Inch display', '27" 16:9 2560 x 1440 @75Hz with 1ms HDMI, DisplayPort, Dual-link 
DVI and VGA Picture-in-picture and Picture-by-picture Tilt, Swivel, Pivot, Height adjustment', 
220, 3),
('32-Inch 4K UHD display', '16:9 display, 300cd/m2, 3:000:1, 3840x2160 4K, AMD FreeSync, DP, 2x HDMI, Tilt, VESA mount ', 
410, 4),
('34-inch QHD Ultrawide Curved dislay', '21:9 1500R Curved display, 300cd/m2, 3000:1, 3440x1440, 
100Hz, 4ms, (GTG), AMD FreeSync, Thunderbolt 3, DP, HDMI, USB Hub, USB Type C, Tilt, VESA Mount ', 
835, 7);

INSERT INTO os (name, description, price, quantity)
VALUES ('Windows 8', 'The previous version of Desktop Operating System from Microsoft. All features are unlocked in this version', 
80, 555),
('Windows 10 Home', 'The latest Desktop Operating System from Microsoft. Best for home users', 
120, 333),
('Windows 10 Pro', 'The latest Desktop Operating System from Microsoft. Best 
for computer enthusiasts and offices. All features are unlocked in this version. ', 
180, 444),
('Ubuntu 18.04 LTS', ' Open-source user-friendly Linux Operating System', 
20, 7);


SELECT * FROM computers WHERE isCusomized != true;


INSERT INTO computers (name, description, pictureURL, price, quantity, cpuID, ramID, hddID, 
    audioCardID, videoCardID, displayID, OSID, isCustomizable, isCustomized, compatibleComponents, URL)
VALUES ('Office computer', 'CPU: 7th Generation Intel Core i3-7100T | Graphics: Intel HD Graphics
 | RAM: 4GB | Storage: 500GB HDD | Connectivity: Gigabit Ethernet | Windows 8', 
'resources/pictures/computer-158675_1280.png', 850, 15, 1, 1, 1, 8, 4, 1, 1, true, false, 
    'cpuID[1, 2, 3]; ramID: [1, 2, 3]; hddID: [1, 2, 3]; audioCardID: [0, 1]; 
videoCardID: [0, 1]; displayID: [1, 2, 3]; OSID: [1, 2, 4]', 'officeComputer.xhtml');	

INSERT INTO computers (name, description, pictureURL, price, quantity, cpuID, ramID, hddID, 
    audioCardID, videoCardID, displayID, OSID, isCustomizable, isCustomized, compatibleComponents, URL)
VALUES ('Gaming computer', 'CPU: Intel Core i7-8700K | GPU: Nvidia GeForce GTX 1070 Ti 8GB | RAM: 16GB DDR4 | Storage: 256 SSD + 1TB HDD  Windows 10', 
'resources/pictures/computer-158743.png', 1489, 27, 4, 3, 5, 9, 6, 3, 3, true, false, 
    'cpuID[3, 4]; ramID: [2, 3]; hddID: [2, 3, 4, 5, 6]; audioCardID: [9, 10]; 
videoCardID: [6, 7]; displayID: [2, 3, 4]; OSID: [2, 3]', 'gammingComputer.xhtml');

CREATE table users (
    userID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    firstName VARCHAR(555) NOT NULL,
    lastName VARCHAR(555) NOT NULL,    
    email VARCHAR(555) NOT NULL,
    login VARCHAR(555) NOT NULL,
    password VARCHAR(555) NOT NULL,
    address VARCHAR(555) NOT NULL,
    pnone VARCHAR(555) NOT NULL,
    accountCreatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    logedLastTimeDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP);	

CREATE table feedbacks (
    feedbackID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    email VARCHAR(555) NOT NULL, 
    wouldRecommend BOOLEAN NOT NULL,    
    comment VARCHAR(8888) NOT NULL,
    dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

CREATE table Orders (
    orderID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    userID INT NOT NULL, 
    totalPrice INT NOT NULL,    
    datePlaced TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    foreign key(userID) references users(userID));

CREATE table OrderDetails (
    orderID INT NOT NULL,
    computerID INT NOT NULL, 
    quantity INT NOT NULL,    
    price INT NOT NULL,
    foreign key(orderID) references orders(orderID),
    foreign key(computerID) references computers(computerID)
);