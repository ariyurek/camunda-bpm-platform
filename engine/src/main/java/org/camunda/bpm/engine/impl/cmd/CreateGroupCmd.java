/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.engine.impl.cmd;

import java.io.Serializable;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.impl.interceptor.Command;
import org.camunda.bpm.engine.impl.interceptor.CommandContext;

import static org.camunda.bpm.engine.impl.util.EnsureUtil.ensureNotNull;
import static org.camunda.bpm.engine.impl.util.EnsureUtil.ensureWhitelistedResourceId;

/**
 * @author Tom Baeyens
 */
public class CreateGroupCmd extends AbstractWritableIdentityServiceCmd<Group> implements Command<Group>, Serializable {

  private static final long serialVersionUID = 1L;
  
  protected String groupId;
  
  public CreateGroupCmd(String groupId) {
    ensureNotNull("groupId", groupId);
    this.groupId = groupId;
  }
  
  protected Group executeCmd(CommandContext commandContext) {
    ensureWhitelistedResourceId(commandContext, "Group", groupId);

    return commandContext
      .getWritableIdentityProvider()
      .createNewGroup(groupId);
  }

}
