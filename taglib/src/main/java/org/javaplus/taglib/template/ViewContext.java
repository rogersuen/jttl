/* $Id: ViewContext.java,v 1.2 2006/06/02 02:19:17 stephen Exp $
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

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * <p><tt>ViewContext</tt> provides the context information for template
 * tags.</p>
 *
 * @author Stephen Suen
 */
public class ViewContext {
    
    private Stack<ViewParent> viewParentStack;
    private Stack<ParamParent> paramParentStack;
    
    /**
     * Creates a new instance of <tt>ViewContext</tt>.
     */
    public ViewContext() {
        viewParentStack = new Stack<ViewParent>();
        paramParentStack = new Stack<ParamParent>();
        viewParentStack.push(new ViewParentSupport());
        paramParentStack.push(new ParamParentSupport());
    }
    
    /**
     * <p>Saves the specified <tt>ViewParent</tt> instance onto the
     * <tt>ViewParent</tt> stack. After that, any directly nested
     * &lt;t:view&gt; tags or &lt;t:view&gt; tags without containing
     * <tt>ViewParent</tt> tags in the template being called by this
     * <tt>ViewParent</tt> tags will take it as parent.</p>
     *
     * @param viewParent the current <tt>ViewParent</tt> instance
     * @return the given <tt>ViewParent</tt> instance
     */
    public ViewParent pushViewParent(ViewParent viewParent) {
        if (viewParent == null)
            throw new NullPointerException("null viewParent");
        return viewParentStack.push(viewParent);
    }
    
    /**
     * <p>Returns the previous <tt>ViewParent</tt> instance saved by the
     * matching <tt>pushViewParent()</tt>, and removes it from the
     * <tt>ViewParent</tt> stack.</p>
     *
     * @return the previous <tt>ViewParent</tt> instance
     * @throws EmptyStackException if the <tt>ViewParent</tt> stack is empty
     */
    public ViewParent popViewParent() {
        return viewParentStack.pop();
    }
    
    /**
     * <p>Returns the previous <tt>ViewParent</tt> instance saved by the
     * the <tt>pushViewParent()</tt>.</p>
     *
     * @return the previous <tt>ViewParent</tt> instance, or <tt>null</tt>
     *         if the <tt>ViewParent</tt> stack is empty
     */
    public ViewParent getViewParent() {
        if (viewParentStack.empty())
            return null;
        else
            return viewParentStack.peek();
    }
    
    /**
     * Searches for the named view in the stack of <tt>ViewParent</tt>
     * instances and returns the view associated or <tt>null</tt>.
     *
     * @param name the name of the view to search for
     * @return the view associated or <tt>null</tt>
     */
    public View findView(String name) {
        if (name == null)
            throw new NullPointerException("null name");
        
        int index = viewParentStack.size();
        while (--index >= 0) {
            ViewParent viewParent = viewParentStack.get(index);
            View result = viewParent.getLocalView(name);
            if (result != null)
                return result;
        }
        return null;
    }
    
    /**
     * Adds the specified view to the previous <tt>ViewParent</tt> instance
     * saved by the the <tt>pushViewParent()</tt>.
     *
     * @param view the view instance to add
     */
    public void addView(View view) {
        if (view == null)
            throw new NullPointerException("null view");
        viewParentStack.peek().addLocalView(view);
    }
    
    /**
     * <p>Saves the specified <tt>ParamParent</tt> instance onto the
     * <tt>ParamParent</tt> stack. After that, any directly nested
     * &lt;t:param&gt; tags or &lt;t:param&gt; tags without containing
     * <tt>ParamParent</tt> tags in the template being called by this
     * <tt>ParamParent</tt> tags will take it as parent.</p>
     *
     * @param paramParent the current <tt>ParamParent</tt> instance
     * @return the given <tt>ParamParent</tt> instance
     */
    public ParamParent pushParamParent(ParamParent paramParent) {
        if (paramParent == null)
            throw new NullPointerException("null paramParent");
        return paramParentStack.push(paramParent);
    }
    
    /**
     * <p>Returns the previous <tt>ParamParent</tt> instance saved by the
     * matching <tt>pushParamParent()</tt>, and removes it from the
     * <tt>ParamParent</tt> stack.</p>
     *
     * @return the previous <tt>ParamParent</tt> instance
     * @throws EmptyStackException if the <tt>ParamParent</tt> stack is empty
     */
    public ParamParent popParamParent() {
        return paramParentStack.pop();
    }
    
    /**
     * <p>Returns the previous <tt>ParamParent</tt> instance saved by the
     * the <tt>pushParamParent()</tt>.</p>
     *
     * @return the previous <tt>ParamParent</tt> instance, or <tt>null</tt>
     *         if the <tt>ParamParent</tt> stack is empty
     */
    public ParamParent getParamParent() {
        if (paramParentStack.empty())
            return null;
        else
            return paramParentStack.peek();
    }
    
    // a convenient stack implemetation without unnecessary synchronization
    class Stack<E> {
        
        private ArrayList<E> array = new ArrayList<E>();
        
        E push(E item) {
            array.add(item);
            return item;
        }
        
        E pop() {
            E result = peek();
            int len = array.size();
            array.remove(len - 1);
            return result;
        }
        
        E peek() {
            int len = array.size();
            
            if (len == 0)
                throw new EmptyStackException();
            return array.get(len - 1);
        }
        
        E get(int index) {
            return array.get(index);
        }
        
        int size() {
            return array.size();
        }
        
        boolean empty() {
            return (array.size() == 0);
        }
    }
}
