package org.agilewiki.jfile.transactions;

import org.agilewiki.jactor.RP;
import org.agilewiki.jid.scalar.vlens.string.StringJid;

/**
 * Base class of transactions with a String.
 */
abstract public class _StringTransactionJid extends StringJid implements Transaction {
    private RP requestReturn;

    public void transactionResult(RP rp)
            throws Exception {
        requestReturn = rp;
    }

    public void eval(Eval req, final RP rp) throws Exception {
        if (requestReturn == null) {
            eval(req.blockTimestamp, rp);
        } else {
            eval(req.blockTimestamp, new RP<Integer>() {
                @Override
                public void processResponse(Integer response) throws Exception {
                    rp.processResponse(null);
                    requestReturn.processResponse(response);
                }
            });
        }
    }

    /**
     * Evaluate the transaction.
     * @param rp      The response processor.
     */
    abstract protected void eval(long blockTimestamp, RP rp)
            throws Exception;
}