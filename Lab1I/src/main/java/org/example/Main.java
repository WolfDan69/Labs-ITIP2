package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    // Создаём логгер
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Приложение запущено");
        log.debug("Это сообщение отладки (уровень debug)"); // по умолчанию не покажется, т.к. уровень info
        log.error("Пример ошибки"); // всегда видно
    }
}