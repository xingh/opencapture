/*
Copyright 2008 Filter Logic

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://wwwthis.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package net.filterlogic.util;

import java.io.*;

/**
* Simple utilities to return the stack trace of an
* exception as a String.
*/
public final class StackTraceUtil 
{

  public static String getStackTrace(Throwable aThrowable) 
  {

      try
      {
    final Writer result = new StringWriter();
    final PrintWriter printWriter = new PrintWriter(result);
    aThrowable.printStackTrace(printWriter);
    return result.toString();
      }
      catch(Exception e)
      {
          return aThrowable.toString() + "\n" + e.toString();
      }
  }

  /**
  * Defines a custom format for the stack trace as String.
  */
  public static String getCustomStackTrace(Throwable aThrowable) {
    //add the class name and any message passed to constructor
    final StringBuilder result = new StringBuilder( "OOPS: " );
    result.append(aThrowable.toString());
    final String NEW_LINE = System.getProperty("line.separator");
    result.append(NEW_LINE);

    //add each element of the stack trace
    for (StackTraceElement element : aThrowable.getStackTrace() ){
      result.append( element );
      result.append( NEW_LINE );
    }
    return result.toString();
  }
} 
