# ДЗ 13. Словари

0. Создать класс FileNavigator. Класс предназначен для хранения списка файлов, располагаемые по концертному пути.

Например: /path/to/file -> [files.txt, firstApp.java]


1. Создать класс FileData. Класс представляет конкретный файл и состоит из: имя файла, размер в байтах, путь к файлу.


2. Реализовать метод add в классе FileNavigator. Данный метод добавляет файл по указанному пути. Если путь уже существует, то новый файл необходимо добавить к списку, уже связанному с соответствующим путем. ВАЖНО: Путь - уникальное значение и не должно повторяться.


3. Реализовать метод find в классе FileNavigator. Метод возвращает список файлов связанных с путем переданным в качестве параметра.


4. Реализовать метод filterBySize в классе FileNavigator. Метод возвращает список файлов, размер (в байтах) которых не превышает значение переданное в качестве параметра.


5. Реализовать метод remove в классе FileNavigator. Метод удаляет путь и связанные с ним файлы, на основании значения пути, переданного в качестве параметра.


6. * Реализовать метод sortBySize в классе FileNavigator. Метод сортирует все имеющиеся файлы по их размеру (по возрастанию), затем возвращает список отсортированных файлов.


7. ** Реализовать проверку консистентности в методе add в классе FileNavigator. Не позволять добавлять значения и сообщить об этом в консоль, при попытке добавить значение FileData значение пути которого не соответствует пути-ключу ведущему к списку файлов.

Например:

Должна быть ошибка, поскольку путь-ключ и путь к файлу не совпадают

Путь: /path/to/file

FileData: {name: ..., size: ..., path: /another/path/}