# Game-SpaceWars

Space Wars 

In a galaxy far away, you are an Admiral of the United Forces Fleet (UFF) fighting battles against a number of different 
enemies who are part of the Terraworld Empire and use a number of different types of battle tactics. To win, you must 
assemble, from the UFF, an Active Star Fleet (ASF) which can meet (and hopefully win) these battles with your 
enemies. The game provides a collection of different forces which you can activate Initially, all UFF forces are in 
reserve (“in dock”) and not part of your Active Star Fleet ASF.

You have at your disposal 1000 bit coins in your war chest. As the admiral, you must assemble your Active Star Fleet 
by activating some of the forces in the United Forces Fleet(UFF) dock. However, activating a force will cost money 
which you must pay out of your war chest. You will then be expected to undertake some battles. Winning a battle will 
bring you gains (bit coins) and increase your war chest. Losing a battle will cost you and decrease your war chest. In 
addition, if a force is defeated in a battle, it is destroyed and cannot be used again.
Your enemies offer different types of battle tactics. Each battle has a unique number (allocated sequentially from 1 by 
the system), a battle type, the enemy name, enemy strength, gains and losses. For this prototype, the player will select 
a battle by its number (in later versions the battle will be chosen using random numbers). The system will then find the 
first appropriate force in your Active Star Fleet to engage in the battle. It compares battle strengths of your force and the 
enemy. The results of a battle will be one of the following:

1. “Battle won by the ASF force" – add battle gains to the war chest
2. “Battle lost as no suitable force available” – deduct the battle losses from war chest 
3. “Battle lost by force on battle strength ” - deduct battle losses from war chest, destroy your  force

Currently, battles may be undertaken more than once.

Each force has a unique fleet reference, a full name, an activation fee, and battle strength. There are three types of 
forces: Wings, Starships, WarBirds and each has additional features. WarBirds need an activation fee of 300 bit coins, 
but if they have a cloaking device the fee is 400 bit coins. Starships set their activation fee based on the number of 
laser canons (30 bit coins for each laser cannon) and Wings have an activation fee of 200 bit coins. The battle strength 
of a Wing is 20 for each of its strikers. The battle strength of a Starship is 5 for each photon torpedo and 10 for each 
laser cannon. WarBird can have different war strengths (See Appendix A)

In order to save resources and lives, the Chiefs of Staff have decided that Wings should not be used in fights, Starships 
should not be sent on ambushes and WarBirds should not be used in skirmishes. In addition, WarBirds can only be 
used for ambushes, if they have a cloaking device. (see below)

<html xmlns:v="urn:schemas-microsoft-com:vml"
xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">

<head>

<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 15">
<link id=Main-File rel=Main-File
href="file:///C:/Users/lewis/AppData/Local/Temp/msohtmlclip1/01/clip.htm">
<link rel=File-List
href="file:///C:/Users/lewis/AppData/Local/Temp/msohtmlclip1/01/clip_filelist.xml">
</head>

<body link="#0563C1" vlink="#954F72">



  | Skirmish | Ambush | Fight
-- | -- | -- | --
Wings | yes | yes | no
Starship | yes | no | yes
WarBird | no | yes, if has cloaking | yes



</body>

</html>

During the game, a force can be in one of the following states:

 docked – in the United Forces Fleet (UFF) , but not yet activated as part of your Active Star Fleet(ASF)

 Active – activated as part of your ASF and available for battles

 destroyed – defeated and cannot be recalled or used further in battles

After losing a battle, your war chest may be < 0 and you may not be able to activate more forces. However, you can 
continue to undertake battles with your forces in the hope of winning some more money (even if your war chest goes 
further into debt). You may also make money by recalling forces back to the dock, when half of their activation cost is 
added back to your war chest. However, if your war chest has no money or is in debt, and you have no forces to recall, 
then you have lost the game and a suitable message should be returned. Forces may be activated or recalled at any 
point in the game. 

Appendix A – Data used in game 

Forces
<html xmlns:v="urn:schemas-microsoft-com:vml"
xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">

<head>

<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 15">
<link id=Main-File rel=Main-File
href="file:///C:/Users/lewis/AppData/Local/Temp/msohtmlclip1/01/clip.htm">
<link rel=File-List
href="file:///C:/Users/lewis/AppData/Local/Temp/msohtmlclip1/01/clip_filelist.xml">

</head>

<body link="#0563C1" vlink="#954F72">
<span role=presentation dir=ltr style='box-sizing: border-box;color:transparent;
transform-origin: 0% 0%;font-variant-ligatures: normal;font-variant-caps: normal;
orphans: 2;text-align:start;widows: 2;-webkit-text-stroke-width: 0px;
text-decoration-thickness: initial;text-decoration-style: initial;text-decoration-color: initial;
transform: scaleX(1.04817)'><span role=presentation dir=ltr style='box-sizing: border-box;
color:transparent;transform-origin: 0% 0%;font-variant-ligatures: normal;
font-variant-caps: normal;orphans: 2;text-align:start;widows: 2;-webkit-text-stroke-width: 0px;
text-decoration-thickness: initial;text-decoration-style: initial;text-decoration-color: initial;
transform: scaleX(1.04817)'><span role=presentation dir=ltr style='box-sizing: border-box;
color:transparent;transform-origin: 0% 0%;font-variant-ligatures: normal;
font-variant-caps: normal;orphans: 2;text-align:start;widows: 2;-webkit-text-stroke-width: 0px;
text-decoration-thickness: initial;text-decoration-style: initial;text-decoration-color: initial;
transform: scaleX(1.04817)'>



Reference | Name | Fee | Strikers | Laser Cannons | Photon Torpedoes | Strength | Cloaking | Force
-- | -- | -- | -- | -- | -- | -- | -- | --
IW1 | Twister | 200 | 10 |   |   | 200 |   | Wing
SS2 | Enterprise | 300 |   | 10 | 20 | 200 |   | Starship
WB3 | Droop | 300 |   |   |   | 100 | no | WarBird
IW4 | Wingers | 200 | 20 |   |   | 400 |   | Wing
WB5 | Hang | 400 |   |   |   | 300 | yes | WarBird
SS6 | Voyager | 450 |   | 15 | 10 | 200 |   | Starship
SS7 | Explorer | 120 |   | 4 | 5 | 65 |   | StarShip
WB9 | Hover | 300 |   |   |   | 400 | no | WarBird
IW10 | Flyers | 200 | 5 |   |   | 100 |   | Wing



</body>

</html>

Battles 
<html xmlns:v="urn:schemas-microsoft-com:vml"
xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">

<head>

<meta name=ProgId content=Excel.Sheet>
<meta name=Generator content="Microsoft Excel 15">
<link id=Main-File rel=Main-File
href="file:///C:/Users/lewis/AppData/Local/Temp/msohtmlclip1/01/clip.htm">
<link rel=File-List
href="file:///C:/Users/lewis/AppData/Local/Temp/msohtmlclip1/01/clip_filelist.xml">

</head>

<body link="#0563C1" vlink="#954F72">



Battle No. | Type | Enemy | Enemy Strength | Losses | Gains
-- | -- | -- | -- | -- | --
1 | Fight | Borg | 200 | 300 | 100
2 | Skirmish | Kardassians | 700 | 200 | 120
3 | Ambush | Ferengi | 100 | 400 | 150
4 | Fight | Ewoks | 600 | 600 | 200
5 | Ambush | Borg | 500 | 400 | 90
6 | Skirmish | Groaners | 150 | 100 | 100
7 | Fight | Borg | 150 | 500 | 300
8 | Ambush | Wailers | 300 | 300 | 300



</body>

</html>

Example of output upon running the games user interface:

Entering admirals name results in a selection of options that the user can choose from. 

![image](https://user-images.githubusercontent.com/65728188/150787102-43192063-59f1-4151-902d-100c209e9ec1.png)

Output when selecting option 3.

![image](https://user-images.githubusercontent.com/65728188/150787464-b5decc15-4927-44fa-865c-c06aaf0fc825.png)
