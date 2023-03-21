# simulation file system in memmory
Harded task from EPAM.

Программа, эмулирующую модель файловой системы, ее иерархическую структуру. Т.е., имеем два типа объектов: каталог (Folder) и файл (File) со следующими свойствами:
Каталог и файл имеют свойство - имя.
В каталог можно добавлять другие файлы и каталоги, в произвольном порядке, произвольное количество.
В файл нельзя добавлять другие каталоги или файлы.
Файл имеет расширение. Каталог – нет.
Вывод имеет древовидную структуру.

Программа принимает на вход строку, представляющую собой путь к файлу/каталогу в некой структуре каталогов (например “root/folder1/file.txt”), и строит дерево соответствующих объектов в памяти.
Пользователь может ввести следующую строку-путь, которая может содержать каталоги из предыдущего пути (например “root/folder2/file.txt”) – в таком случае, к уже существующему пути будут добавлены новые каталоги и файлы.

Пользователь в любой момент может вывести на экран получившуюся структуру каталогов.
Пользователь в любой момент может завершить работу с программой.

В любой момент времени пользователь может сохранить состояние получившейся структуры директорий на диск и выйти из программы. Далее, при следующим запуске, программа позволяет считать последнее сохраненное состояние и продолжить работу со структурой директорий.

Важно! Эта программа не о работе с файловой системой. 
Не создаются реальные файлы и папки на диске. 
Только виртуальная структура в памяти!
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
A programme that emulates the file system model and its hierarchical structure. That is, there are two types of objects: Folder and File with the following properties:
A directory and a file have the property of a name.
Other files and directories can be added to the directory, in any order, and in any number of directories.
Other directories or files cannot be added to a file.
A file has an extension. A directory does not.
The output has a tree structure.

The program takes as input a string representing the path to a file/directory in some directory structure (e.g. "root/folder1/file.txt") and builds a tree of corresponding objects in memory.
The user can enter the next path string, which can contain directories from the previous path (e.g. "root/folder2/file.txt") - in this case, new directories and files will be added to the already existing path.

The user can display the resulting directory structure at any time.
The user can terminate the program at any time.

At any time the user can save the state of the resulting directory structure to disk and exit the programme. The next time the program is started, it allows the user to read the last saved state and continue working with the directory structure.

Important! This programme is not about working with the file system. 
It does not create real files and folders on disk. 
Only a virtual structure in memory!
