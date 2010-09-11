//
// MessagePack-RPC for Java
//
// Copyright (C) 2010 FURUHASHI Sadayuki
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package org.msgpack.rpc;

import java.io.IOException;
import org.msgpack.*;

public class NotificationMessage implements MessagePackable {
	private String method;
	private Object[] args;

	public NotificationMessage(String method, Object[] args) {
		this.method = method;
		this.args = args;
	}

	public String getMethodName() {
		return method;
	}

	public Object[] getArguments() {
		return args;
	}

	@Override
	public void messagePack(Packer pk) throws IOException {
		pk.packArray(3);
		pk.packInt(2);  // FIXME Messages.NOTIFY
		pk.packString(method);
		pk.packArray(args.length);
		for(Object arg : args) {
			pk.pack(arg);
		}
	}

	// FIXME messageConvert
}
