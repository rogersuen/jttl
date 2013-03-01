/* $Id: ParamTag.java,v 1.2 2006/06/06 02:29:04 stephen Exp $
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

/**
 * <p>The &lt;t:param&gt; tag allows developers to define a parameter
 * with a default value for a template, or provide a parameter
 * with a runtime value when calling a template from the containing
 * &lt;t:view&gt; or &lt;t:render&gt; tags.</p>
 *
 * @author Stephen Suen
 * @see RenderTag
 * @see ViewTag
 */
public class ParamTag extends TemplateTagSupport {

    private String name;                    // "name" attribute
    private Object value;                   // "value" attribute

    /**
     * Sets the "name" attribute.
     * @param name the view name
     */
    public void setName(String name) {
        this.name = name.trim();
    }
    
    /**
     * Sets the "value" attribute.
     * @param value the value object, possibly be <tt>null</tt>
     */
    public void setValue(Object value) {
        this.value = value;
    }

    public int doEndTag() throws JspException {
	// take no action for null or empty names
	if (name == null || name.equals(""))
	    return EVAL_PAGE;

        // if the value is null, try to use body content
        ParamParent parent = viewContext.getParamParent();
	if (value == null) {
	    if (bodyContent != null && bodyContent.getString() != null)
		value = bodyContent.getString().trim();
	}

        parent.addParameter(name, value);
	return EVAL_PAGE;
    }

    public void release() {
        name = null;
        value = null;
        super.release();
    }
}
