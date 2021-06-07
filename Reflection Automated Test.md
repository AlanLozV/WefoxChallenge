﻿# Reflection on Automated Test

I would describe the automated test case for the Lego page as a Component Test and of course as an Integration Test. Since Integration Test is usually performed as automated testing, the scope of this functional test is appropriate and accurate because it will test that the actions, data and commands flow correctly through the different modules and together in the system. In other words, it will assert that modules act as part of a whole.

The goal of a Component Test is to evaluate a module or component to verify functionality, usability and the expected output. Considering this, the automated test could also be considered as a component test because it performs actions through different modules of the system trying to get an output that must match the expected result.

A Unit test would not be very helpful compared to a Component or Integration test because the main objective of it, is to detect bugs in an early stage of development which means, testing the code trying to break it.

For the rest of the functional testing types, I consider the scopes are helpful in different ways. A Smoke test would help us to verify the basic functionalities after a new build by the developers is released since the test cases for this scope should cover the most important functions or components of the system. In a similar way, a Sanity test would reveal if modification have fixed existing issues and of course, detect that new issues have not been introduced. The main disadvantage of this type of testing is that it does not perform a deep or an exploratory test over the “secondary” components or modules.

But for exploratory tests we have either Regression or System testing scopes. In Regression testing the scope is also considered to evaluate that a change or addition hasn’t broken an existing functionality but a Regression suite usually involves more coverage. The system testing is conducted on a complete, integrated system to validate its compliance with specified requirements and may be performed in an environment that could mirror production environment. Both types of functional testing are useful when the development reaches an advanced stage or previous releases are approved and stable.