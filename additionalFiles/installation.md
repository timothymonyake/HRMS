
### Installation
> This article assumes you have installed **Java** JDK or JRE, if not please search google and get your java environment up and running.

Extended Installation instructions can be found [here]().
In quick short steps :

1. Configure file paths
    - inside __src/org/bush/utilitities/Utilities.java__ change the default directory where the file will be chosen from, its a path stored in _search_dir_ variable.

2. Change in application overview file path
  - inside __src/org/bush/utilitities/Utilities.java__ change the path of the _readme.txt_ file, this is stored inside _brz_ variable.

3. After making changes and saving, run the __MainClass.java__ file.

add to long instr file
~~~java
File search_dir = new File("/root/");
/*change from /root/ to your preferred directory.*/
~~~

Because data is stored in text files, its very important to know where these are.

1. System overview

When the application loads, there is a file that loads with it, it basically has the
system overview, what the system is, what its meant to do and the target end users. This file
loads on the default container pane of the application.

This file is contained within <src/org/bush/utilititie/> and called <readme.txt>. Wherever you choose to
place this file you must also pass the resulting path to the file as an argument to the File constructor(File())
inside the method sysOverview().

Now this differs across many platforms

* (a) Linux users
* (b) Windows users

2. Employee database text file
