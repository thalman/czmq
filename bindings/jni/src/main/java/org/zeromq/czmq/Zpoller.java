/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Please refer to the README for information about making permanent changes.  #
################################################################################
*/
package org.zeromq.czmq;

public class Zpoller implements AutoCloseable{
    static {
        try {
            System.loadLibrary ("czmqjni");
        }
        catch (Exception e) {
            System.exit (-1);
        }
    }
    long self;
    /*
    Create new poller; the reader can be a libzmq socket (void *), a zsock_t
    instance, or a zactor_t instance.                                       
    */
    native static long __init (long reader);
    public Zpoller (long reader) {
        /*  TODO: if __init fails, self is null...  */
        self = __init (reader);
    }
    public Zpoller () {
        self = 0;
    }
    /*
    Destroy a poller
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Add a reader to be polled. Returns 0 if OK, -1 on failure. The reader may
    be a libzmq void * socket, a zsock_t instance, or a zactor_t instance.   
    */
    native static int __add (long self, long reader);
    public int add (long self, long reader) {
        return __add (self, reader);
    }
    /*
    Remove a reader from the poller; returns 0 if OK, -1 on failure. The   
    reader may be a libzmq void * socket, a zsock_t instance, or a zactor_t
    instance.                                                              
    */
    native static int __remove (long self, long reader);
    public int remove (long self, long reader) {
        return __remove (self, reader);
    }
    /*
    Poll the registered readers for I/O, return first reader that has input.  
    The reader will be a libzmq void * socket, or a zsock_t or zactor_t       
    instance as specified in zpoller_new/zpoller_add. The timeout should be   
    zero or greater, or -1 to wait indefinitely. Socket priority is defined   
    by their order in the poll list. If you need a balanced poll, use the low 
    level zmq_poll method directly. If the poll call was interrupted (SIGINT),
    or the ZMQ context was destroyed, or the timeout expired, returns NULL.   
    You can test the actual exit condition by calling zpoller_expired () and  
    zpoller_terminated (). The timeout is in msec.                            
    */
    native static long __wait (long self, int timeout);
    public long Wait (long self, int timeout) {
        return __wait (self, timeout);
    }
    /*
    Return true if the last zpoller_wait () call ended because the timeout
    expired, without any error.                                           
    */
    native static boolean __expired (long self);
    public boolean expired (long self) {
        return __expired (self);
    }
    /*
    Return true if the last zpoller_wait () call ended because the process
    was interrupted, or the parent context was destroyed.                 
    */
    native static boolean __terminated (long self);
    public boolean terminated (long self) {
        return __terminated (self);
    }
    /*
    Ignore zsys_interrupted flag in this poller. By default, a zpoller_wait will 
    return immediately if detects zsys_interrupted is set to something other than
    zero. Calling zpoller_ignore_interrupts will supress this behavior.          
    */
    native static void __ignore_interrupts (long self);
    public void ignoreInterrupts (long self) {
        __ignore_interrupts (self);
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public void test (boolean verbose) {
        __test (verbose);
    }
}
