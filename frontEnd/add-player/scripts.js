import { savePlayer } from "../../requests/requests.js";

const handleSubmitButton = async () => {
    const form = document.querySelector("form")
    form.addEventListener("submit", async (e) => {
        e.preventDefault()
        const player = {
            id: form.playerId.value,
            name: form.playerName.value,
            lastName: form.playerLastName.value,
            email: form.playerEmail.value,
            playStartDate: form.playStartDate.value,
        }
        await savePlayer(player)
        window.location.reload()
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
    handleClearButton()
    handleCancelButton()
    await handleSubmitButton()
})()