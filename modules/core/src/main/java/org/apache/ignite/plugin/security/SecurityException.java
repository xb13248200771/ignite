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

package org.apache.ignite.plugin.security;

import org.apache.ignite.IgniteException;
import org.jetbrains.annotations.Nullable;

/**
 * Common security exception for the grid.
 */
public class SecurityException extends IgniteException {
    /** */
    private static final long serialVersionUID = 0L;

    /**
     * Constructs security grid exception with given message and cause.
     *
     * @param msg Exception message.
     * @param cause Exception cause.
     */
    public SecurityException(
        String msg,
        @Nullable Throwable cause
    ) {
        super(msg, cause);
    }

    /**
     * Creates new security grid exception given throwable as a cause and
     * source of error message.
     *
     * @param cause Non-null throwable cause.
     */
    public SecurityException(Throwable cause) {
        this(cause.getMessage(), cause);
    }

    /**
     * Constructs security grid exception with given message.
     *
     * @param msg Exception message.
     */
    public SecurityException(String msg) {
        super(msg);
    }
}