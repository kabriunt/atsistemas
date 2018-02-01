use clinic

insert into doctor values (0,null,"lastname1","name1"),
(0,null,"lastname2","name2"),(0,null,"lastname3","name3"),
(0,null,"lastname4","name4"),(0,null,"lastname5","name5"),
(0,null,"lastname6","name6"),(0,null,"lastname7","name7"),
(0,null,"lastname8","name8"),(0,null,"lastname9","name9");

insert into patient values (0,"lastname1","name1"),
(0,"lastname2","name2"),(0,"lastname3","name3"),
(0,"lastname4","name4"),(0,"lastname5","name5"),
(0,"lastname6","name6"),(0,"lastname7","name7"),
(0,"lastname8","name8"),(0,"lastname9","name9"),
(0,"lastname10","name10"),(0,"lastname11","name11"),
(0,"lastname12","name12"),(0,"lastname13","name13"),
(0,"lastname14","name14"),(0,"lastname15","name15"),
(0,"lastname16","name16"),(0,"lastname17","name17");

insert into clinic values (0,"adress1","name1"),
(0,"adress2","name2"),(0,"adress3","name3");

insert into room values (0,"name1",1),
(0,"name2",1),(0,"name3",2),
(0,"name4",1),(0,"name5",2),
(0,"name6",1),(0,"name7",2),
(0,"name8",1),(0,"name9",2),
(0,"name10",3),(0,"name11",2),
(0,"name12",3),(0,"name13",2),
(0,"name14",2),(0,"name15",2),
(0,"name16",2),(0,"name17",2);

insert into consultation values(0,"M",CURDATE(),2,4),
(0,"M",CURDATE(),3,4),(0,"M",CURDATE(),4,4),
(0,"M",CURDATE(),5,4),(0,"M",CURDATE(),6,4),
(0,"M",CURDATE(),7,4),(0,"M",CURDATE(),8,4);

insert into appointment values (0,1,1),
(0,2,2),(0,3,3),
(0,4,4),(0,5,5),
(0,6,6),(0,7,7),
(0,1,8),(0,2,9),
(0,3,10),(0,4,11),
(0,6,12),(0,5,13),
(0,7,14),(0,1,15),
(0,1,16),(0,1,17);
