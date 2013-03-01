/* $Id: ViewParentSupport.java,v 1.2 2006/06/02 02:19:17 stephen Exp $
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

/**
 * Base support class to facilitate implementation of <tt>ViewParent<tt>
 * tags.
 *
 * @author Stephen Suen
 */
public class ViewParentSupport implements ViewParent {
    
    private HashMap<String, View> localViews = new HashMap<String, View>();
    
    /**
     * Creates a new instance of <tt>ViewParentSupport</tt>.
     */
    public ViewParentSupport() {
        init();
    }
    
    private void init() {
        localViews.clear();
    }
    
    public void addLocalView(View view) {
        if (view == null)
            throw new NullPointerException("null view");
        
        String name = view.getName();
        
        // if the view with the same name has been defined locally,
        // ignore this one silently
        if (localViews.containsKey(name))
            return;
        
        localViews.put(name, view);
    }
    
    public View getLocalView(String name) {
        if (name == null)
            throw new NullPointerException("null name");
        
        return (View)localViews.get(name);
    }
    
    /**
     * Recycles this instance, make it prepared for reusing.
     */
    public void recycle() {
        init();
    }
}
