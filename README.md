# collect-tk
A blockchain miner is a computer or group of computers that validate transactions on a blockchain network by solving complex mathematical problems, also known as "proof of work." When a miner successfully solves a problem, they are rewarded with cryptocurrency and their solution is added to the blockchain as a new block. This process is known as mining. Miners play a crucial role in maintaining the integrity and security of the blockchain by ensuring that only valid transactions are added to the blockchain.

This client uses a PoS: Proof of Stake (PoS) is a type of consensus algorithm used by some blockchain networks as an alternative to the proof of work (PoW) algorithm used by Bitcoin and other networks. In PoS, instead of miners competing to solve mathematical problems and earn rewards, validators (often called "stakers") are chosen to create new blocks and validate transactions based on the amount of cryptocurrency they hold and are willing to "stake" as collateral.

PoS is considered more energy-efficient than PoW because it does not require miners to perform large amounts of computational work, and it is also considered more secure because it is more difficult for a single entity to gain control of a majority of the network's staked assets. However, it also has its own set of criticisms such as centralization, nothing at stake problem etc.

![mining-schema](https://user-images.githubusercontent.com/117292926/214807734-ef283381-e979-440c-869e-850d383fa5cd.png)

## Configuration
The client will create a .tkm-chain folder and a JSON file (collect_tk_client_config_file.json) inside with the basic information needed to run it.
```
{

    "baseUrlEndpoint":"http://localhost:8080",
    "requireChallengeApi":"/requirechallenge",
    "checkResultApi":"/checkresult",
    "checkclaimingSolutionsApi":"/checkclamingsolutions",
    "getHexTrxApi":"/gethextrx",
    "updateClamingSolutionsApi":"/updateclaimsolutions",
    "savePayTodoApi":"/savepaytodo"

}
```
