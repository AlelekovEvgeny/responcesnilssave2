простой maven проект для считывания XML файла в дериктории и извлечения из него данных с дальнейшей закачкой в OracleDB
1. Для развёртывания проекта нужен maven и ваша любимая IDE.
2. В классе AppSnilsSave есть прямые пути к папкам откуда брать файлы и куда перезаписывать. Пропишите удобные для вас.
3. В папке OracleConnection необходимо создать class Login с переменными url, user, password и соответственно прописать
ваши настройки подключения к OracleDB.
4. Также необходимо подключить драйвер ojdbc6. Можно ввести команду в консоле, либо из IDE. Например в IntelliJ IDEA
меню View/Tool Windows/Maven Projects/Execute Maven Goal и ввести строку: 
mvn install:install-file -Dfile=C:\\Java\\ojdbc6-11.2.0.4.0.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar
у вас будет немного другая, в зависимости от директории, где лежит файл.