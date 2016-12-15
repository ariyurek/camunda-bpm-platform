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
package org.camunda.bpm.integrationtest.functional.bpmnmodelapi.beans;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.FlowElement;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * @author Daniel Meyer
 *
 */
@Named
@ApplicationScoped
public class BpmnElementRetrievalDelegate implements JavaDelegate {

  private FlowElement bpmnModelElementInstance;
  private BpmnModelInstance bpmnModelInstance;

  @Override
  public void execute(DelegateExecution execution) throws Exception {

    bpmnModelElementInstance = execution.getBpmnModelElementInstance();
    bpmnModelInstance = execution.getBpmnModelInstance();

  }

  public FlowElement getBpmnModelElementInstance() {
    return bpmnModelElementInstance;
  }

  public BpmnModelInstance getBpmnModelInstance() {
    return bpmnModelInstance;
  }

}
