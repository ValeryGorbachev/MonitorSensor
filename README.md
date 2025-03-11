# Monitor Sensors Application

Приложение для мониторинга датчиков с возможностью CRUD операций и разграничением прав доступа.

## Технологии

- Java 11
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Swagger
- Docker

## Запуск приложения

### Локальный запуск

1. Убедитесь, что у вас установлены:
   - Java 11
   - Maven
   - PostgreSQL

    
4. Запустите приложение:
```bash
java -jar target/monitor-sensors-1.0-SNAPSHOT.jar
```

## Доступ к приложению

- API доступно по адресу: http://localhost:8080
- Swagger UI доступен по адресу: http://localhost:8080/swagger-ui/

## Учетные данные

- Администратор:
  - Логин: admin
  - Пароль: password
  
- Пользователь:
  - Логин: user
  - Пароль: password

## API Endpoints

- GET /api/sensors - получить список всех датчиков
- GET /api/sensors/{id} - получить датчик по ID
- POST /api/sensors/create - создать новый датчик
- PUT /api/sensors/update/{id} - обновить датчик
- DELETE /api/sensors/delete/{id} - удалить датчик

## Права доступа

- Administrator - полный доступ ко всем операциям
- Viewer - только просмотр списка датчиков 
