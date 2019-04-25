/*
 * Copyright 2019 GridGain Systems, Inc. and Contributors.
 *
 * Licensed under the GridGain Community Edition License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.gridgain.com/products/software/community-edition/gridgain-community-edition-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.ml.inference.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.ignite.ml.inference.util.DirectorySerializer;

/**
 * Model reader that reads directory or file and serializes it using {@link DirectorySerializer}.
 */
public class FileSystemModelReader implements ModelReader {
    /** */
    private static final long serialVersionUID = 7370932792669930039L;

    /** Path to the directory. */
    private final String path;

    /**
     * Constructs a new instance of directory model reader.
     *
     * @param path Path to the directory.
     */
    public FileSystemModelReader(String path) {
        this.path = path;
    }

    /** {@inheritDoc} */
    @Override public byte[] read() {
        try {
            File file = Paths.get(path).toFile();
            if (!file.exists())
                throw new IllegalArgumentException("File or directory does not exist [path=" + path + "]");

            if (file.isDirectory())
                return DirectorySerializer.serialize(Paths.get(path));
            else
                return Files.readAllBytes(Paths.get(path));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
