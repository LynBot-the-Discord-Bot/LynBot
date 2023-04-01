package io.github.lynbean.lynbot.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import io.github.lynbean.lynbot.util.BotLogger;

public class ThreadController {
    private static final Logger log = BotLogger.getLogger(ThreadController.class);
    public static final ExecutorService commandExecutor = Executors.newCachedThreadPool(
        new ThreadFactoryBuilder()
            .setNameFormat("Bot CommandHandler-Worker %d")
            .setUncaughtExceptionHandler(
                (t, e) -> {
                    log.error(
                        "Uncaught exception in thread {}: {}", t.getName(), e.getMessage()
                    );
                    e.printStackTrace();
                }
                )
                .build()
            );

    public static final ExecutorService eventExecutor = Executors.newCachedThreadPool(
        new ThreadFactoryBuilder()
            .setNameFormat("Bot Event-Worker %d")
            .setUncaughtExceptionHandler(
                (t, e) -> {
                    log.error(
                        "Uncaught exception in thread {}: {}", t.getName(), e.getMessage()
                    );
                    e.printStackTrace();
                }
            )
            .build()
    );
}
