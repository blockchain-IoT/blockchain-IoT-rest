package org.blockchainiot.java.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class IdentifyMachine extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b6040516104b43803806104b4833981016040528080518201919050508060019080519060200190610041929190610048565b50506100c0565b82805482825590600052602060002090810192821561008a579160200282015b82811115610089578251829060001916905591602001919060010190610068565b5b509050610097919061009b565b5090565b6100bd91905b808211156100b95760008160009055506001016100a1565b5090565b90565b6103e5806100cf6000396000f300606060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680632cfbd2b01461007d5780633c9ab950146100be578063789dd26e146100fd578063cb4c61751461013e578063d5bfebe814610165578063fb242aef1461018c575b600080fd5b341561008857600080fd5b6100a26004808035600019169060200190919050506101cb565b604051808260ff1660ff16815260200191505060405180910390f35b34156100c957600080fd5b6100df60048080359060200190919050506101eb565b60405180826000191660001916815260200191505060405180910390f35b341561010857600080fd5b61012260048080356000191690602001909190505061020f565b604051808260ff1660ff16815260200191505060405180910390f35b341561014957600080fd5b610163600480803560001916906020019091905050610259565b005b341561017057600080fd5b61018a6004808035600019169060200190919050506102a5565b005b341561019757600080fd5b6101b1600480803560001916906020019091905050610308565b604051808215151515815260200191505060405180910390f35b60006020528060005260406000206000915054906101000a900460ff1681565b6001818154811015156101fa57fe5b90600052602060002090016000915090505481565b600080151561021d83610308565b1515141561022a57600080fd5b600080836000191660001916815260200190815260200160002060009054906101000a900460ff169050919050565b6001151561026682610308565b1515141561027357600080fd5b600180548060010182816102879190610368565b91600052602060002090016000839091909150906000191690555050565b600015156102b282610308565b151514156102bf57600080fd5b6001600080836000191660001916815260200190815260200160002060008282829054906101000a900460ff160192506101000a81548160ff021916908360ff16021790555050565b600080600090505b60018054905081101561035d57826000191660018281548110151561033157fe5b9060005260206000209001546000191614156103505760019150610362565b8080600101915050610310565b600091505b50919050565b81548183558181151161038f5781836000526020600020918201910161038e9190610394565b5b505050565b6103b691905b808211156103b257600081600090555060010161039a565b5090565b905600a165627a7a72305820462e5ad69afd2cbb31a1c7fd6cbedba20db554f9a8daf0143dadc38f0bf06fe30029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
        _addresses.put("5777", "0xf25186b5081ff5ce73482ad761db0eb0d25abfbf");
    }

    protected IdentifyMachine(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IdentifyMachine(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> ignites(byte[] param0) {
        final Function function = new Function("ignites", 
                Arrays.<Type>asList(new Bytes32(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> machineList(BigInteger param0) {
        final Function function = new Function("machineList", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> totalIgnitionsFor(byte[] machine) {
        final Function function = new Function(
                "totalIgnitionsFor", 
                Arrays.<Type>asList(new Bytes32(machine)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addMachine(byte[] machine) {
        final Function function = new Function(
                "addMachine", 
                Arrays.<Type>asList(new Bytes32(machine)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> igniteMachine(byte[] machine) {
        final Function function = new Function(
                "igniteMachine", 
                Arrays.<Type>asList(new Bytes32(machine)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> machineListed(byte[] machine) {
        final Function function = new Function(
                "machineListed", 
                Arrays.<Type>asList(new Bytes32(machine)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<IdentifyMachine> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> machines) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Bytes32>(
                        org.web3j.abi.Utils.typeMap(machines, Bytes32.class))));
        return deployRemoteCall(IdentifyMachine.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<IdentifyMachine> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<byte[]> machines) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<Bytes32>(
                        org.web3j.abi.Utils.typeMap(machines, Bytes32.class))));
        return deployRemoteCall(IdentifyMachine.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static IdentifyMachine load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IdentifyMachine(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static IdentifyMachine load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IdentifyMachine(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
