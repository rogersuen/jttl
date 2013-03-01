/* $Id$
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

import java.util.HashMap;
import javax.servlet.jsp.PageContext;

/**
 * <p>Base class to facilitate implementation of valid parent tags for
 * &lt;t:param&gt;.</p>
 *
 * <p>This base class provides support for:</p>
 *
 * <ul>
 *   <li>Accepting a parameter if it has not been added before.</li>
 *   <li>Exposing and unexposing the scoped variables.</tt>.
 * </ul>
 *
 * @author Stephen Suen
 */
public class ParamParentSupport implements ParamParent {
    
    private HashMap<String, Object> parameters =
            new HashMap<String, Object>();
    
    // prior attributes should be restored when unexposing variables
    private HashMap<String, Object> attributes =
            new HashMap<String, Object>();
    
    /**
     * Creates a new instance of <tt>ParamParentSupport</tt>.
     */
    public ParamParentSupport() {
        init();
    }
    
    private void init() {
        parameters.clear();
        attributes.clear();
    }
    
    public boolean addParameter(String name, Object value) {
        if (name == null)
            throw new NullPointerException("null name");
        
        // if the parameter with the same has been defined
        // (possibly from the caller), ignore this one
        // (possibly the local one providing default) silently
        if (parameters.containsKey(name))
            return false;
        
        parameters.put(name, value);
        return true;
    }
    
    /**
     * <p>Exposes the specified scoped variable using the given
     * <tt>PageContext</tt>.</p>
     *
     * <p>The variable is exposed as a request-scoped attribute.</p>
     *
     * @param name          the name of the variable to be exposed
     * @param value         the value of the variable to be exposed
     * @param pageContext   the <tt>PageContext</tt> instance used to expose
     *                      the variable
     */
    public void exposeVariable(String name, Object value,
            PageContext pageContext) {
        if (name == null)
            throw new NullPointerException("null name");
        if (pageContext == null)
            throw new NullPointerException("null pageContext");
        
        Object o = pageContext.getAttribute(name, PageContext.REQUEST_SCOPE);
        if (o != null)
            attributes.put(name, o);
        
        pageContext.setAttribute(name,
                parameters.get(name),
                PageContext.REQUEST_SCOPE);
    }
    
    /**
     * <p>Removes variables we have exposed as request-scoped attributes
     * using the specified <tt>PageContext</tt> instance.</p>
     *
     * <p>If applicable, restores attributes to their prior values.</p>
     *
     * @param pageContext   the <tt>PageContext</tt> instance used to
     *                      unexpose the variable
     */
    public void unexposeVariables(PageContext pageContext) {
        if (pageContext == null)
            throw new NullPointerException("null pageContext");
        
        // remove parameters
        for (String key: parameters.keySet()) {
            pageContext.removeAttribute(key, PageContext.REQUEST_SCOPE);
        }
        
        // restore the saved attributes
        for (String key: attributes.keySet()) {
            pageContext.setAttribute(key,
                    attributes.get(key),
                    PageContext.REQUEST_SCOPE);
        }
    }
    
    /**
     * Recycles this instance, make it prepared for reusing.
     */
    public void recycle() {
        init();
    }
}
