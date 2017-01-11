/**
 * Copyright (C) 2015 Michael Schnell. All rights reserved. <http://www.fuin.org/>
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library. If not, see <http://www.gnu.org/licenses/>.
 */
package org.fuin.utils4maven;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.junit.Test;

/**
 * Test for the {@link MavenPomReader} class.
 */
// CHECKSTYLE:OFF Test code
public class MavenPomReaderTest {

    @Test
    public void testReadModel() throws IOException {

        // PREPARE
        final String expected = IOUtils.toString(getClass()
                .getResourceAsStream("/objects4j.xml"), Charset.forName("ISO-8859-1"));

        // TEST
        final Model model = MavenPomReader
                .readModel("org.fuin:objects4j:0.6.1");

        // VERIFY
        final MavenXpp3Writer writer = new MavenXpp3Writer();
        final StringWriter sw = new StringWriter();
        writer.write(sw, model);
        assertThat(sw.toString()).isEqualTo(expected);
        assertThat(model.getName()).isEqualTo("Objects4J");
        assertThat(model.getScm()).isNotNull();
        assertThat(model.getScm().getUrl()).isEqualTo("https://github.com/fuinorg/objects4j/");
        
        

    }

}
// CHECKSTYLE:ON
