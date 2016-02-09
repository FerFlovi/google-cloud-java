/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.examples.resourcemanager.snippets;

import com.google.gcloud.resourcemanager.Project;
import com.google.gcloud.resourcemanager.ProjectInfo;
import com.google.gcloud.resourcemanager.ResourceManager;
import com.google.gcloud.resourcemanager.ResourceManagerOptions;

/**
 * A snippet for Google Cloud Resource Manager showing how to create a project if it does not exist.
 */
public class GetOrCreateProject {

  public static void main(String... args) {
    // Create Resource Manager service object.
    // By default, credentials are inferred from the runtime environment.
    ResourceManager resourceManager = ResourceManagerOptions.defaultInstance().service();

    String myProjectId = "my-globally-unique-project-id"; // Change to a unique project ID.
    // Get a project from the server.
    Project myProject = resourceManager.get(myProjectId);
    if (myProject == null) {
      // Create a project.
      myProject = resourceManager.create(ProjectInfo.builder(myProjectId).build());
    }
    System.out.println("Got project " + myProject.projectId() + " from the server.");
  }
}
