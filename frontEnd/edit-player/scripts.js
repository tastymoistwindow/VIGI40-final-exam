import { getPlayerByID, patchPlayer } from "../../requests/requests.js"

const editPlayerForm = document
    .getElementById("editPlayerForm")
    .querySelector("form")

let oldPlayerData

const loadPlayerData = async () => {
    const urlParams = new URLSearchParams(window.location.search)
    const playerId = urlParams.get("id")

    oldPlayerData = await getPlayerByID(playerId)

    editPlayerForm.playerName.value = oldPlayerData.name
    editPlayerForm.playerLastName.value = oldPlayerData.lastName
    editPlayerForm.playerEmail.value = oldPlayerData.email
    editPlayerForm.playStartDate.value = oldPlayerData.playStartDate

}

const handleFormSubmit = async () => {
    editPlayerForm.addEventListener("submit", async (e) => {
        e.preventDefault()

        const player = {
            name:
                oldPlayerData.name !== editPlayerForm.playerName.value
                    ? editPlayerForm.playerName.value
                    : undefined,
            lastName:
                oldPlayerData.lastName !== editPlayerForm.playerLastName.value
                    ? editPlayerForm.playerLastName.value
                    : undefined,
            email:
                oldPlayerData.email !== editPlayerForm.playerEmail.value
                    ? editPlayerForm.playerEmail.value
                    : undefined,
            playStartDate:
                oldPlayerData.playStartDate !== editPlayerForm.playStartDate.value
                    ? editPlayerForm.playStartDate.value
                    : undefined,
        }

        await patchPlayer(player, oldPlayerData.id);
        window.location.replace("../player-list/player-list.html")
    })
}

const handleClearButton = () => {
    document.getElementById("clearBtn").addEventListener("click", () => {
        alert("Form cleared")
    })
}

const handleCancelButton = () => {
    document.getElementById("cancelBtn").addEventListener("click", () => {
        window.location.replace("../player-list/player-list.html")
    })
}

(async () => {
    await loadPlayerData()
    handleClearButton()
    handleCancelButton()
    await handleFormSubmit()
})()
