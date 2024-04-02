# Setup in IntelliJ Idea
1. Download and install JDK 8: [Liberica JDK](https://github.com/bell-sw/Liberica/releases)
2. Set `JAVA_HOME` variable: [Baelbung](https://www.baeldung.com/java-home-on-windows-mac-os-x-linux) / [Atlassian](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
3. Edit `gradle.propetries` and `settings.gradle.kts` for yourself.
4. Run `gradlew setupDecompWorkspace idea` in command line.
5. Open `ProjectName.ipr` generated file.
6. In notification press `Load Gradle Project` -> `Trust Project`.
7. Edit run configurations (Minecraft Client/Server) for main module classpath.
8. Done.

# Apply Access Transformers
1. In `./src/main/resources/` create `META-INF` folder.
2. Put in your `{mod_id}_at.cfg`.
3. Run task `setupDecompWorkspace`.
4. Reload Gradle cache.
5. **Don't forgot specify your AT config in MANIFEST!**