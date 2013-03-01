/* $Id: ViewParent.java,v 1.1.1.1 2006/05/26 01:51:52 stephen Exp $
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
 * Interface for tag handlers implementing tags that support nested
 * &lt;t:view&gt; tags.
 * @author Stephen Suen
 */
public interface ViewParent {

    /**
     * Adds a local view definition to this <tt>ViewParent</tt>.
     *
     * @param view the view locally defined for this <tt>ViewParent</tt>
     * @throws NullPointerException if the specified view is <tt>null</tt>
     */
    public void addLocalView(View view);

    /**
     * Returns the view with the specified name and locally defined
     * in this <tt>ViewParent</tt>.
     *
     * @param name name whose associated view is to be returned
     * @return a locally deinfed view with the specified name, or
     *         <tt>null</tt> if this <tt>ViewParent</tt> has not
     *         such a view defined locally
     * @throws NullPointerException if the specified name is <tt>null</tt>
     */
    public View getLocalView(String name);

}
