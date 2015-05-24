// CHECKSTYLE:OFF External code
/**
 * Copyright (c) 2011-2012, REMPL.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1) Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.
 * 3) Neither the name of the REMPL.com nor the names of its
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.slf4j.impl;

// Maven API
import org.apache.maven.plugin.logging.Log;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * The binding of {@link ILoggerFactory} class with an actual instance of
 * {@link ILoggerFactory} is performed using information returned by this class.
 * 
 * @author Yegor Bugayenko (yegor@rempl.com)
 * @version $Id$
 * @see <a href="http://www.slf4j.org/faq.html#slf4j_compatible">SLF4J FAQ</a>
 */
public final class StaticLoggerBinder implements LoggerFactoryBinder {

    /**
     * Declare the version of the SLF4J API this implementation is compiled
     * against. The value of this field is usually modified with each release.
     */
    public static final String REQUESTED_API_VERSION = "1.6";

    /**
     * The unique instance of this class.
     */
    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    /**
     * The {@link ILoggerFactory} instance returned by the
     * {@link #getLoggerFactory()} method should always be the same object.
     */
    private final MavenLoggerFactory factory;

    /**
     * The Maven Log.
     */
    private Log log;

    /**
     * Private ctor to avoid direct instantiation of the class.
     */
    private StaticLoggerBinder() {
        this.factory = new MavenLoggerFactory();
    }

    /**
     * Return the singleton of this class.
     * 
     * @return The StaticLoggerBinder singleton
     */
    public static StaticLoggerBinder getSingleton() {
        return StaticLoggerBinder.SINGLETON;
    }

    /**
     * Set Maven Log.
     * 
     * @param mlog
     *            The log from Maven plugin
     */
    public void setMavenLog(final Log mlog) {
        this.log = mlog;
    }

    /**
     * Set Maven Log.
     * 
     * @return The log from Maven plugin
     */
    public Log getMavenLog() {
        if (this.log == null) {
            throw new IllegalStateException(
                    "You should initialize StaticLoggerBinder with #setMavenLog()"
                            + " before any log message is sent to or by Maven plugin");
        }
        return this.log;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ILoggerFactory getLoggerFactory() {
        return this.factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLoggerFactoryClassStr() {
        return this.factory.getClass().getName();
    }

}
// CHECKSTYLE:ON
