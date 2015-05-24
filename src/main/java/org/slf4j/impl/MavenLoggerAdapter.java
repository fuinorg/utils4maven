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
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

/**
 * Implementation of {@link org.slf4j.Logger} transforming SLF4J messages to
 * Maven log messages. The class has too many methods, but we can't do anything
 * with this since the parent class requires us to implement them all.
 * 
 * @author Yegor Bugayenko (yegor@rempl.com)
 * @version $Id$
 * @see <a href="http://www.slf4j.org/faq.html#slf4j_compatible">SLF4J FAQ</a>
 */
public final class MavenLoggerAdapter extends MarkerIgnoringBase {

    /**
     * Serialization ID.
     */
    public static final long serialVersionUID = 0x12C09767;

    /**
     * Get Maven logger.
     * 
     * @return The Maven log
     */
    private Log log() {
        return StaticLoggerBinder.getSingleton().getMavenLog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTraceEnabled() {
        return false;
        // return this.log().isDebugEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(final String msg) {
        this.log().debug(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(final String format, final Object arg) {
        this.log().debug(this.format(format, arg));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(final String format, final Object arg1, final Object arg2) {
        this.log().debug(this.format(format, arg1, arg2));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(final String format, final Object[] argArray) {
        this.log().debug(this.format(format, argArray));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void trace(final String msg, final Throwable thr) {
        this.log().debug(msg, thr);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDebugEnabled() {
        return this.log().isDebugEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(final String msg) {
        this.log().debug(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(final String format, final Object arg) {
        this.log().debug(this.format(format, arg));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(final String format, final Object arg1, final Object arg2) {
        this.log().debug(this.format(format, arg1, arg2));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(final String format, final Object[] argArray) {
        this.log().debug(this.format(format, argArray));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void debug(final String msg, final Throwable thr) {
        this.log().debug(msg, thr);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(final String msg) {
        this.log().info(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(final String format, final Object arg) {
        this.log().info(this.format(format, arg));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(final String format, final Object arg1, final Object arg2) {
        this.log().info(this.format(format, arg1, arg2));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(final String format, final Object[] argArray) {
        this.log().info(this.format(format, argArray));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void info(final String msg, final Throwable thr) {
        this.log().info(msg, thr);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(final String msg) {
        this.log().warn(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(final String format, final Object arg) {
        this.log().warn(this.format(format, arg));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(final String format, final Object[] argArray) {
        this.log().warn(this.format(format, argArray));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(final String format, final Object arg1, final Object arg2) {
        this.log().warn(this.format(format, arg1, arg2));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warn(final String msg, final Throwable thr) {
        this.log().warn(msg, thr);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(final String msg) {
        this.log().error(msg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(final String format, final Object arg) {
        this.log().error(this.format(format, arg));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(final String format, final Object arg1, final Object arg2) {
        this.log().error(this.format(format, arg1, arg2));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(final String format, final Object[] argArray) {
        this.log().error(this.format(format, argArray));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(final String msg, final Throwable thr) {
        this.log().error(msg, thr);
    }

    /**
     * Format with one object.
     * 
     * @param format
     *            Format to use
     * @param arg
     *            One argument
     * @return The message
     */
    private String format(final String format, final Object arg) {
        final FormattingTuple tuple = MessageFormatter.format(format, arg);
        return tuple.getMessage();
    }

    /**
     * Format with two objects.
     * 
     * @param format
     *            Format to use
     * @param arg1
     *            First argument
     * @param arg2
     *            Second argument
     * @return The message
     */
    private String format(final String format, final Object arg1, final Object arg2) {
        final FormattingTuple tuple = MessageFormatter.format(format, arg1, arg2);
        return tuple.getMessage();
    }

    /**
     * Format with array.
     * 
     * @param format
     *            Format to use
     * @param argArray
     *            List of arguments
     * @return The message
     */
    private String format(final String format, final Object[] argArray) {
        final FormattingTuple tuple = MessageFormatter.format(format, argArray);
        return tuple.getMessage();
    }

}
// CHECKSTYLE:ON
