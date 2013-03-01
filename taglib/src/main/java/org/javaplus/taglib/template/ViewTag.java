/* $Id: ViewTag.java,v 1.2 2006/06/06 00:08:41 stephen Exp $
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
import javax.servlet.jsp.JspException;

/**
 * Defines (or overrides) a named view.
 *
 * @author  Stephen Suen
 */

public class ViewTag extends RenderTag {
    
    private String name;                // "name" tag attribute
    private ViewContent viewContent;
    
    /**
     * Sets the "name" attribute.
     * @param name the view name
     */
    public void setName(String name) {
        this.name = name.trim();
    }
    
    public int doStartTag() throws JspException {
        // FIXME: how to avoid recursive view definition?
        viewContent = new ViewContent();
        pageContext.pushBody(viewContent);
        return super.doStartTag();
    }
    
    public int doAfterBody() throws JspException {
        // Using body content if the template attribute of the view tag
        // is not given
        if (template == null || template.equals("")) {
            try {
                bodyContent.writeOut(getPreviousOut());
            } catch (IOException ex) {
                throw new JspException(ex);
            }
        }

        return SKIP_BODY;
    }
    
    public int doEndTag() throws JspException {
        int result = super.doEndTag();
        // FIXME: make sure the writer pop out is ours
        pageContext.popBody();
        viewContext.addView(new View(name, viewContent));
        return result;
    }
    
    public void release() {
        name = null;
        viewContent = null;
        super.release();
    }
}
