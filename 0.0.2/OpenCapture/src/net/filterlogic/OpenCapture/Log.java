/*
Copyright 2008 Filter Logic

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package net.filterlogic.OpenCapture;

import net.filterlogic.util.DateUtil;
import net.filterlogic.util.NamedValueList;

/**
 *
 * @author Darron Nesbitt <jd_nesbitt@hotmail.com>
 */
public class Log 
{
    private String QueueName = "";
    private String StartDateTime = "";
    private String EndDateTime = "";
    private String Host = "";
    private String Message = "";

    public Log(String queueName, String host)
    {
        this.QueueName = queueName;
        this.Host = host;
    }

    public Log(String queueName, String openDate, String closeDate, String host, String message) throws OpenCaptureException
    {
        if(queueName.trim().length()<1)
            throw new OpenCaptureException("Queue name cannot be empty!");

        if(host.trim().length()<1)
            throw new OpenCaptureException("Host cannot be empty!");

        if(openDate.trim().length()<1)
            openDate = DateUtil.getDateTime();

        this.QueueName = queueName;
        this.StartDateTime = openDate;
        this.EndDateTime = closeDate;
        this.Host = host;
        this.Message = message;
    }

    /**
     * Returns a name value list of this objects properties.
     * @return net.filterlogic.util.NamedValueList
     */
    public NamedValueList getNamedValueList()
    {
        NamedValueList<String,String> nvl = new NamedValueList<String, String>();
        
        nvl.put("QueueName", this.QueueName);
        nvl.put("StartDateTime", this.StartDateTime);
        nvl.put("EndDateTime", this.EndDateTime);
        nvl.put("Host", this.Host);
        nvl.put("Message", this.Message);
        
        return nvl;
    }
    
    public String getQueueName() 
    {
        return QueueName;
    }

    public void setQueueName(String QueueName) {
        this.QueueName = QueueName;
    }

    public String getStartDateTime() {
        return StartDateTime;
    }

    public void setStartDateTime(String StartDateTime) {
        this.StartDateTime = StartDateTime;
    }

    public String getEndDateTime() {
        return EndDateTime;
    }

    public void setEndDateTime(String EndDateTime) {
        this.EndDateTime = EndDateTime;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    
    public String getBatchLogEntry()
    {
        String s = "";

        s = this.QueueName + "," + this.StartDateTime + "," + this.EndDateTime + "," + this.Host + "," + this.Message;

        return s;
    }
}
