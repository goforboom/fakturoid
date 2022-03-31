package utils

import java.nio.file.Files
import java.nio.file.Path

object FileLoader {

    /** Simply load file from "resources" folder and return content as string */
    fun loadResourceFile(fileName: String): String {
        return Files.readString(
            Path.of(
                ClassLoader
                    .getSystemClassLoader()
                    .getResource(fileName)!!
                    .toURI()
            )
        )
    }

}
