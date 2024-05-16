# Установка в IntelliJ Idea
1. Скачайте и установите JDK 8: [Liberica JDK](https://github.com/bell-sw/Liberica/releases)
2. Установите системную переменную `JAVA_HOME`: [Baelbung](https://www.baeldung.com/java-home-on-windows-mac-os-x-linux) / [Atlassian](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
3. Отредактировать `gradle.properties` и `settings.gradle.kts` под ваши нужды.
4. Выполнить `gradlew setupDecompWorkspace idea` в командной строке.
5. Открыть сгенерированный `ProjectName.ipr` файл.
6. В окне уведомления нажать `Load Gradle Project` -> `Trust Project`.
7. В конфигурации запуска (Minecraft Client/Server) сменить ClassPath на модуль main, применить.
8. Готово.

# Применение Access Transformers
1. В `./src/main/resources/` создать папку `META-INF`.
2. Положить в неё ваш `{mod_id}_at.cfg`.
3. Выполнить таск `setupDecompWorkspace`.
4. Перезагрузить кеш Gradle.
5. **Не забываем указать наш конфиг в MANIFEST!**
