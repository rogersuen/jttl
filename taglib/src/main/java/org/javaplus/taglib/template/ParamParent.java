/* $Id: ParamParent.java,v 1.1 2006/06/02 02:19:17 stephen Exp $
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

/**
 * <p>Interface for tag handlers implementing valid parent tags for
 * &lt;t:param&gt;.</p>
 *
 * @author Stephen Suen
 */
public interface ParamParent {
    
    /**
     * Adds a parameter to the parameter parent tag.
     * @param name   the parameter name, can not be <tt>null</tt>
     * @param value  the parameter value, possibly <tt>null</tt>
     * @return       <tt>true</tt> if the parameter is added as a result
     *               of the call, or <tt>false</tt> if a parameter
     *               with the same name has already been existed
     * @throws       NullPointerException if the specified <tt>name</tt>
     *               is <tt>null</tt>
     */
    public boolean addParameter(String name, Object value);
}
