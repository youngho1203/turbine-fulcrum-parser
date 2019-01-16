package org.apache.fulcrum.parser.pool;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.fulcrum.parser.DefaultParameterParser;


/**
 * Factory to create {@link org.apache.fulcrum.parser.DefaultParameterParser} objects
 *
 * @author <a href="mailto:painter@apache.org">Jeffery Painter</a>
 * @version $Id: DefaultParameterParserFactory.java 1851080 2019-01-16 12:07:00Z painter $
 */
public class DefaultParameterParserFactory 
	extends BasePooledObjectFactory<DefaultParameterParser>
{


	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#create()
	 */
	@Override
	public DefaultParameterParser create() throws Exception 
	{
		return new  DefaultParameterParser();
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.pool2.BasePooledObjectFactory#wrap(java.lang.Object)
	 */
	@Override
	public PooledObject<DefaultParameterParser> wrap(DefaultParameterParser obj) 
	{
		return new DefaultPooledObject<DefaultParameterParser>(obj);
	}
	
   /**
     * When an object is returned to the pool, clear the buffer.
     */
    @Override
    public void passivateObject(PooledObject<DefaultParameterParser> pooledObject) 
    {
        pooledObject.getObject().clear();
    }
    
    /* (non-Javadoc)
     * @see org.apache.commons.pool2.BasePooledObjectFactory#validateObject(org.apache.commons.pool2.PooledObject)
     */
    @Override
    public boolean validateObject(PooledObject<DefaultParameterParser> parser) 
    {
        return parser.getObject().isValid();
    }
    
}
