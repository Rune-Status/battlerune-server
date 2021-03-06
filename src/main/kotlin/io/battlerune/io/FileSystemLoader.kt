package io.battlerune.io

import io.battlerune.game.GameContext
import net.openrs.cache.Cache
import net.openrs.cache.FileStore
import org.apache.logging.log4j.LogManager

class FileSystemLoader(val context: GameContext) : Runnable {

    companion object {
        val logger = LogManager.getLogger()
    }

    override fun run() {
        val cache = Cache(FileStore.open("./data/cache/"))
        val checksumTable = cache.createChecksumTable().encode()
        context.cache = cache
        context.checksumTable = checksumTable

        logger.info("Loaded: file system")
    }

}