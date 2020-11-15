# InstagramClone
We are developing a simpler and abridged version of Instagram for a University Project.

# Students Assigned to different Layers:

Haseeb Ahmed    UI_Console
Rehman Butt     UI_Swing
Usama Zahid     UI_Swing
Ali Humza       DB_Text
Nabeel Hassan   DB_Firebase
Anser Butt      BL(Business Layer)

# Code Compilation and Code Execution

Different layer combinations can be used by manipulating a simple configuration file, by the name of Layer.cfg, placed in the Models package. Setting the “Database” property to “Firebase” allows for the program to work with a DB and setting the property to “Text” allows the program to work in a textual database.  The Interface used can be manipulated by changing the “User_Interface”, property to “Graphical” for a GUI and “Console” for a CLI. The “Main.java” class in the Package “Combination” needs to be run to execute the project.

# Updated Code Interfaces

[embed]
https://drive.google.com/file/d/1fJ2Q2G7lXjIUIEXS44INCc-qVJ7deqhM/view?usp=sharing
[/embed]

[embed]
https://drive.google.com/file/d/1-VQwB7c2Cwr_pANTn51ETQu_R751bUxU/view?usp=sharing
[/embed]

# Design Principles

-Single Purpose - i.e all Modules are developed in such a way as to enusre that they cater to a single responsibility
-Interface Segregation - All Interfaces are created while ensuring that the modules implementing them do not have to implement any functions not part of thei design
-Dependency Inversion - Is ensured by making sure that no one module depends on how another module implements a feature and instead that a module does implement any given feature
-Polymorphism - As there are multiple implementations present for the same layer, polymorphism is used to make sure that program can run smoothly irrespective of layer used. e.g CLI or GUI is used.
