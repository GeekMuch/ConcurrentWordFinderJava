# ConcurrentWordFinderJava
This is an attempt to create a concurrent word finder in java using the ForkJoinPool class in java with recursion. 

There many limitations that could be overcome, one worth mentioning is the scalability of the
size of a file. Files bigger 100mb the application will crash due to lack of memory, this can
possibly be overcome. An other limitation, would be the speed due to the reliability of using the ForkJoinPool.
ForkJoinPool use many resource on running and shutting down different threads.
