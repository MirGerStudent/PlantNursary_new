# Зависимости
Для запуска необходимы: **docker-compose**, **mvn** и **jdk21-openjdk**

# Запуск
## База данных
Сначала необходимо запустить базу данных, развернуть докер контейнер.
```bash
docker-compose up
```

В случае необходимости стиреть базу до состояния по умолчанию (migration/init.sql).
```bash
docker-compose down --volumes
```

## Приложение
Запустить само приложение "на лету".
```bash
mvn spring-boot:run
```

Запустить приложение из скомпилированного jar файла.
```bash
mvn jar:jar
java -jar PlantNursery_new-*.*.*-SNAPSHOT.jar
```