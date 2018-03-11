package org.blockchainiot.java.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
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
public class Machine extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b6040516200108c3803806200108c83398101604052808051820191906020018051820191906020018051906020019091905050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600390805190602001906100989291906100cb565b5081600490805190602001906100af9291906100cb565b5080600581600019169055506000600781905550505050610170565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061010c57805160ff191683800117855561013a565b8280016001018555821561013a579182015b8281111561013957825182559160200191906001019061011e565b5b509050610147919061014b565b5090565b61016d91905b80821115610169576000816000905550600101610151565b5090565b90565b610f0c80620001806000396000f3006060604052600436106100c5576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630a294ab6146100ca5780630ad9d052146100f35780631c43cd04146101815780632e88ab0b146101aa57806332f8290c146101ff57806377fc9f6a146102145780637b33fa251461024d5780638da5cb5b14610262578063aca2d464146102b7578063c6dad082146102e8578063d967f75214610376578063fc0c546a146103ca578063ffa20fad1461041f575b600080fd5b34156100d557600080fd5b6100dd610474565b6040518082815260200191505060405180910390f35b34156100fe57600080fd5b61010661047a565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561014657808201518184015260208101905061012b565b50505050905090810190601f1680156101735780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561018c57600080fd5b610194610518565b6040518082815260200191505060405180910390f35b34156101b557600080fd5b6101bd61051e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561020a57600080fd5b610212610544565b005b341561021f57600080fd5b61024b600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061078d565b005b341561025857600080fd5b610260610a27565b005b341561026d57600080fd5b610275610b66565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156102c257600080fd5b6102ca610b8b565b60405180826000191660001916815260200191505060405180910390f35b34156102f357600080fd5b6102fb610b91565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561033b578082015181840152602081019050610320565b50505050905090810190601f1680156103685780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561038157600080fd5b6103c8600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091908035906020019091908035906020019091905050610c2f565b005b34156103d557600080fd5b6103dd610dc1565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561042a57600080fd5b610432610de7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b60075481565b60038054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105105780601f106104e557610100808354040283529160200191610510565b820191906000526020600020905b8154815290600101906020018083116104f357829003601f168201915b505050505081565b60065481565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156105a257600080fd5b600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231306000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561066757600080fd5b6102c65a03f1151561067857600080fd5b505050604051805190509050806006541115151561069557600080fd5b6107036000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1682600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16610e0d9092919063ffffffff16565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163073ffffffffffffffffffffffffffffffffffffffff167f79d88277d215c99d3f2e100d08eac35bb85faa2881f4f75e825ec5f635b3bdab426040518082815260200191505060405180910390a350565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156107e957600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166370a08231306000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561088c57600080fd5b6102c65a03f1151561089d57600080fd5b50505060405180519050600654111515156108b757600080fd5b80600860006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163073ffffffffffffffffffffffffffffffffffffffff167f4cbd49028dc7260f72696164c28b5c70255626609fa5e857e02e114e7ef8579d426040518082815260200191505060405180910390a350565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a8257600080fd5b6000600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060006006819055506007600081548092919060010191905055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163073ffffffffffffffffffffffffffffffffffffffff167fed5554e5e3f4513393bedcdee6a6407afadd9cd87041fca85a7cb7cb7ad25482426040518082815260200191505060405180910390a3565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60055481565b60048054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c275780601f10610bfc57610100808354040283529160200191610c27565b820191906000526020600020905b815481529060010190602001808311610c0a57829003601f168201915b505050505081565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610c8a57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168473ffffffffffffffffffffffffffffffffffffffff1614151515610cc657600080fd5b806006819055508373ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163073ffffffffffffffffffffffffffffffffffffffff167fd211576039c1c18c9c7ad2fdfd79b420a752353d1c1bcc0ec83f6f24907e85d886868660405180848152602001838152602001828152602001935050505060405180910390a483600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050505050565b600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b8273ffffffffffffffffffffffffffffffffffffffff1663a9059cbb83836000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1515610eb857600080fd5b6102c65a03f11515610ec957600080fd5b505050604051805190501515610edb57fe5b5050505600a165627a7a72305820401b30380eae49097c4b0010da5a432ae43e92b4262a73ee85be159842d3ee1b0029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
        _addresses.put("5777", "0x8f0483125fcb9aaaefa9209d8e9d7b9c8b9fb90f");
    }

    protected Machine(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Machine(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<MachineRentalEventResponse> getMachineRentalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MachineRental", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<MachineRentalEventResponse> responses = new ArrayList<MachineRentalEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            MachineRentalEventResponse typedResponse = new MachineRentalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._machine = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._owner = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._renter = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.startTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.endTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._rentalPrice = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MachineRentalEventResponse> machineRentalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MachineRental", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MachineRentalEventResponse>() {
            @Override
            public MachineRentalEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                MachineRentalEventResponse typedResponse = new MachineRentalEventResponse();
                typedResponse.log = log;
                typedResponse._machine = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._owner = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._renter = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.startTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.endTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._rentalPrice = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public List<RentalClaimedEventResponse> getRentalClaimedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("RentalClaimed", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<RentalClaimedEventResponse> responses = new ArrayList<RentalClaimedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RentalClaimedEventResponse typedResponse = new RentalClaimedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._machine = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._renter = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.claimedTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<RentalClaimedEventResponse> rentalClaimedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("RentalClaimed", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, RentalClaimedEventResponse>() {
            @Override
            public RentalClaimedEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                RentalClaimedEventResponse typedResponse = new RentalClaimedEventResponse();
                typedResponse.log = log;
                typedResponse._machine = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._renter = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.claimedTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<MachineReturnedEventResponse> getMachineReturnedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MachineReturned", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<MachineReturnedEventResponse> responses = new ArrayList<MachineReturnedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            MachineReturnedEventResponse typedResponse = new MachineReturnedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._machine = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._renter = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.returnTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MachineReturnedEventResponse> machineReturnedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MachineReturned", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MachineReturnedEventResponse>() {
            @Override
            public MachineReturnedEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                MachineReturnedEventResponse typedResponse = new MachineReturnedEventResponse();
                typedResponse.log = log;
                typedResponse._machine = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._renter = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.returnTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<ReturnConfirmedEventResponse> getReturnConfirmedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("ReturnConfirmed", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<ReturnConfirmedEventResponse> responses = new ArrayList<ReturnConfirmedEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ReturnConfirmedEventResponse typedResponse = new ReturnConfirmedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._machine = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._owner = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.claimedTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ReturnConfirmedEventResponse> returnConfirmedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("ReturnConfirmed", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ReturnConfirmedEventResponse>() {
            @Override
            public ReturnConfirmedEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                ReturnConfirmedEventResponse typedResponse = new ReturnConfirmedEventResponse();
                typedResponse.log = log;
                typedResponse._machine = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._owner = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.claimedTime = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<BigInteger> rentalCount() {
        final Function function = new Function("rentalCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> model() {
        final Function function = new Function("model", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> rentalPrice() {
        final Function function = new Function("rentalPrice", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> renter() {
        final Function function = new Function("renter", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> returnMachine() {
        final Function function = new Function(
                "returnMachine", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> claimRental(String _token) {
        final Function function = new Function(
                "claimRental", 
                Arrays.<Type>asList(new Address(_token)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> confirmReturn() {
        final Function function = new Function(
                "confirmReturn", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> vin() {
        final Function function = new Function("vin", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> make() {
        final Function function = new Function("make", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> rentMachine(String _pendingRenter, BigInteger startTime, BigInteger endTime, BigInteger price) {
        final Function function = new Function(
                "rentMachine", 
                Arrays.<Type>asList(new Address(_pendingRenter),
                new Uint256(startTime),
                new Uint256(endTime),
                new Uint256(price)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> token() {
        final Function function = new Function("token", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> pendingRenter() {
        final Function function = new Function("pendingRenter", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<Machine> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _model, String _make, byte[] _vin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_model),
                new Utf8String(_make),
                new Bytes32(_vin)));
        return deployRemoteCall(Machine.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Machine> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _model, String _make, byte[] _vin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_model),
                new Utf8String(_make),
                new Bytes32(_vin)));
        return deployRemoteCall(Machine.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Machine load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Machine(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Machine load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Machine(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class MachineRentalEventResponse {
        public Log log;

        public String _machine;

        public String _owner;

        public String _renter;

        public BigInteger startTime;

        public BigInteger endTime;

        public BigInteger _rentalPrice;
    }

    public static class RentalClaimedEventResponse {
        public Log log;

        public String _machine;

        public String _renter;

        public BigInteger claimedTime;
    }

    public static class MachineReturnedEventResponse {
        public Log log;

        public String _machine;

        public String _renter;

        public BigInteger returnTime;
    }

    public static class ReturnConfirmedEventResponse {
        public Log log;

        public String _machine;

        public String _owner;

        public BigInteger claimedTime;
    }
}
