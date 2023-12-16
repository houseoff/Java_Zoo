# Java_Zoo
Итоговая контрольная работа по блоку "Специализация"

Данная программа позволяет вести учёт животных в зоопарке. Программа работает в связке с БД PostgreSQL. 

## Настройка базы данных

Необходимо предварительно скачать и установить базу данных PostgeSQL

После установки и первоначальных настроек выполнить приложенный к проекту SQL-скрипт (файл **script.sql**) для создания таблиц, функций, необходимых для работы программы + для заполнения таблиц тестовыми данными

Для подключения программы к БД требуется заполнить конфигурационный файл **db_config.yaml** след. образом:

- type: postgresql - оставить без изменения
- database: - имя базы данных, которая будет использоваться программой
- server: сервер для подключения к БД
- port: порт для подключения к БД
- user: пользователь для подключения к БД
- password: пароль для подключения к БД

После заполнения файла **db_config.yaml** необходимо запустить программу и в открывшемся меню выбрать пункт "Импортировать подключение из файла" -> "Из YAML-файла", указать путь к файлу **db_config.yaml**