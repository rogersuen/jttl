/* $Id: View.java,v 1.2 2006/06/02 02:19:17 stephen Exp $
 *
 * Copyright 2006 Stephen Suen (stephen.suen@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.javaplus.taglib.template;

import java.io.IOException;
import java.io.Writer;

/**
 * The simple wrapper class for a named view and its content.
 * @author Stephen Suen
 */
public class View {

    private String name;
    private ViewContent viewContent;

    /**
     * Creates a new instance of <tt>View</tt> with the specified
     * <tt>name</tt> and <tt>ViewContent</tt>.
     *
     * @param name          the view name
     * @param viewContent   the <tt>ViewContent</tt> instance containing
     *                      the actual content
     */
    public View(String name, ViewContent viewContent) {
        this.name = name;
        this.viewContent = viewContent;
    }

    /**
     * Returns the view name.
     * @return the view name
     */
    public String getName() {
        return name;
    }

    /**
     * Writes out the content of this <tt>View</tt> instance to the specified
     * writer.
     * @param out           the writer to write to
     * @throws              IOException if an I/O error occurs
     */
    public void writeOut(Writer out) throws IOException {
        viewContent.writeTo(out);
    }
}
