/* $Id: RenderTag.java,v 1.4 2006/06/06 02:37:16 stephen Exp $
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
import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;

/**
 *
 * @author  Stephen Suen
 */
public class RenderTag extends TemplateTagSupport
        implements ViewParent, ParamParent {
    
    protected String template;        // "template" attribute
    
    private ViewParentSupport viewParentSupport =
            new ViewParentSupport();
    private ParamParentSupport paramParentSupport =
            new ParamParentSupport();
    
    public RenderTag() {
        init();
    }
    
    private void init() {
        template = null;
        viewContext = null;
        
        viewParentSupport.recycle();
        paramParentSupport.recycle();
    }
    
    /**
     * Sets the "template" attribute. This attribute is used to specify
     * the template used by this view. It can be another view name or
     * a resource path begin with a "/" and and is interpreted
     * as relative to the current context root.
     *
     * @param template  the template used by this view, could be another
     *                  view name or a resoure path
     */
    public void setTemplate(String template) {
        this.template = template.trim();
    }
    
    public int doStartTag() throws JspException {
        viewContext.pushViewParent(this);
        viewContext.pushParamParent(this);
        return EVAL_BODY_BUFFERED;
    }
    
    public int doEndTag() throws JspException {
        if (template != null && !template.equals("")) {
            View view = viewContext.findView(template);
            try {
                if (view != null)
                    view.writeOut(pageContext.getOut());
                else
                    pageContext.include(template, false);
            } catch (ServletException ex) {
                throw new JspException(ex);
            } catch (IOException ex) {
                throw new JspException(ex);
            }
        }

        paramParentSupport.unexposeVariables(pageContext);
        paramParentSupport.recycle();
        viewParentSupport.recycle();
        viewContext.popParamParent();
        viewContext.popViewParent();

        return EVAL_PAGE;
    }
    
    public void release() {
        init();
        super.release();
    }
    
    public void addLocalView(View view) {
        viewParentSupport.addLocalView(view);
    }
    
    public View getLocalView(String name) {
        return viewParentSupport.getLocalView(name);
    }
    
    public boolean addParameter(String name, Object value) {
        boolean success = paramParentSupport.addParameter(name, value);
        if (success)
            paramParentSupport.exposeVariable(name, value, pageContext);
        return success;
    }
}
