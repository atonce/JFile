package org.agilewiki.jfile.transactions;

import org.agilewiki.jactor.RP;
import org.agilewiki.jid._Jid;

/**
 * Supports Eval requests.
 */
public interface Evaluator extends _Jid {
    public void eval(Eval req, RP<Boolean> rp)
            throws Exception ;
    void sendTransactionResult()
            throws Exception;
}
