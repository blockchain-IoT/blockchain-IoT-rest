package org.blockchainiot.java.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class MachineOwner extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506114fd8061005e6000396000f300606060405260043610610057576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806333bf42851461005c5780638da5cb5b146100c3578063ef08d4a714610118575b600080fd5b341561006757600080fd5b6100816004808035600019169060200190919050506101c5565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156100ce57600080fd5b6100d66101f8565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561012357600080fd5b6101c3600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919080356000191690602001909190505061021d565b005b60016020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561027a57600080fd5b838383610285610435565b8080602001806020018460001916600019168152602001838103835286818151815260200191508051906020019080838360005b838110156102d45780820151818401526020810190506102b9565b50505050905090810190601f1680156103015780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b8381101561033a57808201518184015260208101905061031f565b50505050905090810190601f1680156103675780820380516001836020036101000a031916815260200191505b5095505050505050604051809103906000f080151561038557600080fd5b90508060016000846000191660001916815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508073ffffffffffffffffffffffffffffffffffffffff167fb9363bcb16d2eee2e7eef50a8f3a5cabadec83d32681fe6dd0fe3c3ef5d8f89e426040518082815260200191505060405180910390a250505050565b60405161108c806104468339019056006060604052341561000f57600080fd5b6040516200108c3803806200108c83398101604052808051820191906020018051820191906020018051906020019091905050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600390805190602001906100989291906100cb565b5081600490805190602001906100af9291906100cb565b5080600581600019169055506000600781905550505050610170565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061010c57805160ff191683800117855561013a565b8280016001018555821561013a579182015b8281111561013957825182559160200191906001019061011e565b5b509050610147919061014b565b5090565b61016d91905b80821115610169576000816000905550600101610151565b5090565b90565b610f0c80620001806000396000f3006060604052600436106100c5576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630a294ab6146100ca5780630ad9d052146100f35780631c43cd04146101815780632e88ab0b146101aa57806332f8290c146101ff57806377fc9f6a146102145780637b33fa251461024d5780638da5cb5b14610262578063aca2d464146102b7578063c6dad082146102e8578063d967f75214610376578063fc0c546a146103ca578063ffa20fad1461041f575b600080fd5b34156100d557600080fd5b6100dd610474565b6040518082815260200191505060405180910390f35b34156100fe57600080fd5b61010661047a565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561014657808201518184015260208101905061012b565b50505050905090810190601f1680156101735780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561018c57600080fd5b610194610518565b6040518082815260200191505060405180910390f35b34156101b557600080fd5b6101bd61051e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561020a57600080fd5b610212610544565b005b341561021f57600080fd5b61024b600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061078d565b005b341561025857600080fd5b610260610a27565b005b341561026d57600080fd5b610275610b66565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156102c257600080fd5b6102ca610b8b565b60405180826000191660001916815260200191505060405180910390f35b34156102f357600080fd5b6102fb610b91565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561033b578082015181840152602081019050610320565b50505050905090810190601f1680156103685780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561038157600080fd5b6103c8600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091908035906020019091908035906020019091905050610c2f565b005b34156103d557600080fd5b6103dd610dc1565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561042a57600080fd5b610432610de7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b60075481565b60038054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105105780601f106104e557610100808354040283529160200191610510565b820191906000526020600020905b8154815290600101906020018083116104f357829003601f168201915b505050505081565b60065481565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156105a257600080fd5b600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231306000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561066757600080fd5b6102c65a03f1151561067857600080fd5b505050604051805190509050806006541115151561069557600080fd5b6107036000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1682600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16610e0d9092919063ffffffff16565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163073ffffffffffffffffffffffffffffffffffffffff167f79d88277d215c99d3f2e100d08eac35bb85faa2881f4f75e825ec5f635b3bdab426040518082815260200191505060405180910390a350565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156107e957600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166370a08231306000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561088c57600080fd5b6102c65a03f1151561089d57600080fd5b50505060405180519050600654111515156108b757600080fd5b80600860006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163073ffffffffffffffffffffffffffffffffffffffff167f4cbd49028dc7260f72696164c28b5c70255626609fa5e857e02e114e7ef8579d426040518082815260200191505060405180910390a350565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a8257600080fd5b6000600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060006006819055506007600081548092919060010191905055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163073ffffffffffffffffffffffffffffffffffffffff167fed5554e5e3f4513393bedcdee6a6407afadd9cd87041fca85a7cb7cb7ad25482426040518082815260200191505060405180910390a3565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60055481565b60048054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c275780601f10610bfc57610100808354040283529160200191610c27565b820191906000526020600020905b815481529060010190602001808311610c0a57829003601f168201915b505050505081565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610c8a57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff1614151515610cc657600080fd5b806006819055508373ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163073ffffffffffffffffffffffffffffffffffffffff167fd211576039c1c18c9c7ad2fdfd79b420a752353d1c1bcc0ec83f6f24907e85d886868660405180848152602001838152602001828152602001935050505060405180910390a483600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050505050565b600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b8273ffffffffffffffffffffffffffffffffffffffff1663a9059cbb83836000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1515610eb857600080fd5b6102c65a03f11515610ec957600080fd5b505050604051805190501515610edb57fe5b5050505600a165627a7a72305820401b30380eae49097c4b0010da5a432ae43e92b4262a73ee85be159842d3ee1b0029a165627a7a723058206aaea37d8ef8e5025c6e2cda0745d85a2745b0a47351f248f561117297ac932a0029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
    }

    protected MachineOwner(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MachineOwner(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<NewMachineAddedEventResponse> getNewMachineAddedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("NewMachineAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<NewMachineAddedEventResponse> responses = new ArrayList<NewMachineAddedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            NewMachineAddedEventResponse typedResponse = new NewMachineAddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newMachine = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NewMachineAddedEventResponse> newMachineAddedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("NewMachineAdded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, NewMachineAddedEventResponse>() {
            @Override
            public NewMachineAddedEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                NewMachineAddedEventResponse typedResponse = new NewMachineAddedEventResponse();
                typedResponse.log = log;
                typedResponse.newMachine = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<String> machines(byte[] param0) {
        final Function function = new Function("machines", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createNewMachine(String model, String make, byte[] vin) {
        final Function function = new Function(
                "createNewMachine", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(model), 
                new org.web3j.abi.datatypes.Utf8String(make), 
                new org.web3j.abi.datatypes.generated.Bytes32(vin)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<MachineOwner> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MachineOwner.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MachineOwner> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MachineOwner.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static MachineOwner load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MachineOwner(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static MachineOwner load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MachineOwner(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class NewMachineAddedEventResponse {
        public Log log;

        public String newMachine;

        public BigInteger timestamp;
    }
}
