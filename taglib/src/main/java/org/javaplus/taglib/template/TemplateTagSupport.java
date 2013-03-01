/* $Id: TemplateTagSupport.java,v 1.2 2006/06/06 02:30:31 stephen Exp $
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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * <p>Base class to facilitate implementation of template tags.</p>
 *
 * <p>This base class exposes the current <tt>ViewContext</tt> instance
 * to the subclasses.</p>
 *
 * @author Stephen Suen
 */
public class TemplateTagSupport extends BodyTagSupport {

    private static final String VIEW_CONTEXT_KEY =
            "org.javaplus.taglib.template.viewContext";

    protected ViewContext viewContext;

    public void setPageContext(PageContext pc) {
        super.setPageContext(pc);

        Object obj = pageContext.getAttribute(VIEW_CONTEXT_KEY,
                PageContext.REQUEST_SCOPE);
        if (obj == null) {
            obj = new ViewContext();
            pageContext.setAttribute(VIEW_CONTEXT_KEY,
                    obj, PageContext.REQUEST_SCOPE);
        } else if (!(obj instanceof ViewContext)) {
            String message = "Failed to initialize template service. " +
                    "The desired key for the view context attribute " +
                    "to be saved in page context has been used.";
            throw new RuntimeException(message);
        }

        viewContext = (ViewContext)obj;
    }

    public void release() {
        viewContext = null;
        super.release();
    }
}
